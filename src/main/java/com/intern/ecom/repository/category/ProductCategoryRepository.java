package com.intern.ecom.repository.category;

import com.intern.ecom.entity.category.ProductCategory;
import com.intern.ecom.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Product> {
}