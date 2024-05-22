package com.intern.ecom.repository.attribute;

import com.intern.ecom.entity.attribute.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepository extends JpaRepository<Attribute, String> {
}