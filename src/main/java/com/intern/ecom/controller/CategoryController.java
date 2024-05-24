package com.intern.ecom.controller;

import com.intern.ecom.entity.category.Category;
import com.intern.ecom.entity.category.ProductCategory;
import com.intern.ecom.entity.category.ProductCategoryId;
import com.intern.ecom.entity.product.Product;
import com.intern.ecom.repository.category.CategoryRepository;
import com.intern.ecom.repository.category.ProductCategoryRepository;
import com.intern.ecom.repository.product.ProductRepository;
import com.intern.ecom.support.ProductCategoryRequestData;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-category")
public class CategoryController {
    final
    ProductCategoryRepository productCategoryRepository;
    final CategoryRepository categoryRepository;
    final ProductRepository productRepository;
    public CategoryController(ProductCategoryRepository productCategoryRepository,
                              CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<ProductCategory> assignCategoryToProduct(
            @Valid @RequestBody ProductCategoryRequestData requestData,
            UriComponentsBuilder ucb){
        Category categoryId = new Category();
        categoryId.setUuidCategory(requestData.getUuidCategory());
        Product productId = new Product();
        productId.setUuidProduct(requestData.getUuidProduct());
        ProductCategoryId productCategoryId = new ProductCategoryId();
        productCategoryId.setUuidCategory(categoryId);
        productCategoryId.setUuidProduct(productId);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryId);
        ProductCategory savedProductCategory =  productCategoryRepository.save(productCategory);
        URI locationOfNewProductAttribute = ucb
                .path("product-category/{id}")
                .buildAndExpand(savedProductCategory.getId().getUuidProduct())
                .toUri();
        return ResponseEntity.ok().body(savedProductCategory);
    }

    @GetMapping("/category/{requiredName}")
    public ResponseEntity<List<Product>> findByCategory(@PathVariable String requiredName){
        Optional<Category> categoryOptional = categoryRepository.findByTitle(requiredName);
        if(categoryOptional.isPresent()){
            String categoryId =  categoryOptional.get().getUuidCategory();
            Collection<String> productIds =  productCategoryRepository.findAllByCategoryId(categoryId);
            List<Product> productList = new java.util.ArrayList<>();
            for(String e: productIds){
                Optional<Product> optionalProduct = productRepository.findById(e);
                if (optionalProduct.isPresent()){
                    productList.add(optionalProduct.get());
                }
            }
            return ResponseEntity.ok().body(productList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
