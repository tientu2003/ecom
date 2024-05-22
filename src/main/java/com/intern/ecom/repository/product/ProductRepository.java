package com.intern.ecom.repository.product;

import com.intern.ecom.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}