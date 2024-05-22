package com.intern.ecom.entity.attribute;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "product_attribute")
@IdClass(ProductAttributeId.class)
public class ProductAttribute {
    @Id
    @NotBlank(message = "Attribute ID is required")
    @Size(max = 40,message = "Length of Attribute ID must be under 40")
    @Column(name = "uuid_attribute", nullable = false, length = 40,unique = true)
    private String uuidAttribute;

    @Id
    @NotBlank(message = "Product ID is required")
    @Size(max = 40,message = "Length of Product ID must be under 40")
    @Column(name = "uuid_product", nullable = false, length = 40, unique = true)
    private String uuidProduct;

    @Size(max = 200,message = "Length of Value ProductAttribute must be under 200")
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