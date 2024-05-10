package com.intern.ecom.entity.category;

import com.intern.ecom.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Product> {
}