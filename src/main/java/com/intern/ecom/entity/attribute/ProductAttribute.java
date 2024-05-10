package com.intern.ecom.entity.attribute;

import jakarta.persistence.*;

@Entity
@Table(name = "product_attribute")
@IdClass(ProductAttributeId.class)
public class ProductAttribute {
    @Id
    @Column(name = "uuid_attribute", nullable = false, length = 40,unique = true)
    private String uuidAttribute;

    @Id
    @Column(name = "uuid_product", nullable = false, length = 40, unique = true)
    private String uuidProduct;

    @Column(name = "value", length = 200)
    private String value;

    public String getUuidAttribute() {
        return uuidAttribute;
    }

    public void setUuidAttribute(String uuidAttribute) {
        this.uuidAttribute = uuidAttribute;
    }

    public String getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(String uuidProduct) {
        this.uuidProduct = uuidProduct;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}