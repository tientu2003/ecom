package com.intern.ecom.controller;

import com.intern.ecom.entity.attribute.ProductAttribute;
import com.intern.ecom.repository.attribute.ProductAttributeRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/product-attributes")
public class ProductAttributeController {
    private final ProductAttributeRepository productAttributeRepository;

    public ProductAttributeController(ProductAttributeRepository productAttributeRepository) {
        this.productAttributeRepository = productAttributeRepository;
    }

    @PostMapping
    public ResponseEntity<ProductAttribute> createProductAttribute(
            @Valid @RequestBody ProductAttribute productAttribute,
            UriComponentsBuilder ucb) {

        ProductAttribute savedProductAttribute = productAttributeRepository.save(productAttribute);
        URI locationOfNewProductAttribute = ucb
                .path("product-attributes/{id}")
                .buildAndExpand(savedProductAttribute.getUuidAttribute())
                .toUri();
        return ResponseEntity.ok().body(productAttribute);
    }

    @GetMapping("/{requiredId}")
    public ResponseEntity<ProductAttribute> findProductAttributeByProductId(
            @PathVariable("requiredId") String requiredId) {

        Optional<ProductAttribute> productAttributeOptional = productAttributeRepository.findByUuidProduct(requiredId);

        if (productAttributeOptional.isPresent()) {
            return ResponseEntity.ok().body(productAttributeOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<ProductAttribute> updateProductAttribute(
            @Valid @RequestBody ProductAttribute productAttribute) {

        Optional<ProductAttribute> productAttributeOptional = productAttributeRepository
                .findByUuidProduct( productAttribute.getUuidProduct());

        if (productAttributeOptional.isPresent()) {
            ProductAttribute updatedProductAttribute = productAttributeOptional.get();
            updatedProductAttribute.setUuidAttribute(productAttribute.getUuidAttribute());
            updatedProductAttribute.setValue(productAttribute.getValue());
            productAttributeRepository.save(updatedProductAttribute);
            return ResponseEntity.accepted().body(updatedProductAttribute);
        }
        return ResponseEntity.status(501).build();
    }

    @DeleteMapping("/{requiredId}")
    public ResponseEntity<ProductAttribute> deleteProductAttribute(
            @PathVariable("requiredId") String requiredId) {

        Optional<ProductAttribute> productAttribute = productAttributeRepository
                .findByUuidProduct(requiredId);

        if (productAttribute.isPresent()) {
          productAttributeRepository.deleteById(productAttribute.get().getUuidProduct());
          return ResponseEntity.accepted().body(productAttribute.get());
        }else{
            return ResponseEntity.status(501).build();
        }
    }

}
