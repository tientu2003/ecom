package com.intern.ecom.controller;

import com.intern.ecom.entity.product.Product;
import com.intern.ecom.repository.product.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, UriComponentsBuilder ucb){
        Product savedProduct = productRepository.save(product);
        URI locationOfNewProduct = ucb.path("products/{id}")
                .buildAndExpand(savedProduct.getUuidProduct())
                .toUri();
        return ResponseEntity.ok().body(savedProduct);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<Product> getProducts(@Valid @PathVariable String requestId) {
        Optional<Product> productOptional = productRepository.findById(requestId);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product){
        Optional<Product> productOptional = productRepository.findById(product.getUuidProduct());
        if (productOptional.isPresent()) {
            Product updatedProduct = productOptional.get();
            updatedProduct.setUpdatedDate(Instant.now());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setMetaTitle(product.getMetaTitle());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setQuantity(product.getQuantity());
            updatedProduct.setPublishedDate(product.getPublishedDate());
            updatedProduct.setSummary(product.getSummary());
            updatedProduct.setTitle(product.getTitle());
            updatedProduct.setUuidBranch(product.getUuidBranch());
            try {
                productRepository.save(updatedProduct);
            }catch (Exception e){
                return ResponseEntity.status(501).build();
            }
            Optional<Product> savedProduct = productRepository.findById(product.getUuidProduct());
            if(savedProduct.isPresent()){
                return ResponseEntity.accepted().body(savedProduct.get());
            }else{
                return ResponseEntity.status(501).build();
            }
        }else{
            return ResponseEntity.status(501).build();
        }
    }
    @DeleteMapping("/{requiredId}")
    public ResponseEntity<Product> deleteProduct(@Valid @PathVariable String requiredId){
        try {
            productRepository.deleteById(requiredId);
            return ResponseEntity.accepted().build();
        }catch (Exception e){
            return ResponseEntity.status(501).build();
        }
    }
}
