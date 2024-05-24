package com.intern.ecom.repository.category;

import com.intern.ecom.entity.category.ProductCategory;
import com.intern.ecom.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Product> {
    @Query(value = "select uuid_product from product_category where uuid_category = ?1",nativeQuery = true)
    public Collection<String> findAllByCategoryId(String title);
}