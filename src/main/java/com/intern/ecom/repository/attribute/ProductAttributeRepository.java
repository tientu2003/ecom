package com.intern.ecom.repository.attribute;

import com.intern.ecom.entity.attribute.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, String> {
    public Optional<ProductAttribute> findByUuidProduct(String uuidProduct);
    public Optional<ProductAttribute> findByUuidAttribute(String uuidAttribute);
}