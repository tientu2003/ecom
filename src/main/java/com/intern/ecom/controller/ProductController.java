package com.intern.ecom.controller;

import com.intern.ecom.entity.product.Product;
import com.intern.ecom.repository.product.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<Product> getProducts(@PathVariable String requestId) {
        Optional<Product> productOptional = productRepository.findById(requestId);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
