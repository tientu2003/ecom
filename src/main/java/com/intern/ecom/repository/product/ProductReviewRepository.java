package com.intern.ecom.repository.product;

import com.intern.ecom.entity.product.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, String> {
}