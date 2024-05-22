package com.intern.ecom.repository.attribute;

import com.intern.ecom.entity.attribute.ProductAttribute;
import com.intern.ecom.entity.attribute.ProductAttributeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, ProductAttributeId> {
    public Optional<ProductAttribute> findByUuidProduct(String uuidProduct);
}