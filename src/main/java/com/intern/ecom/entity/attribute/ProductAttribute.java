package com.intern.ecom.entity.attribute;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "product_attribute")
public class ProductAttribute {
    @Size(max = 40)
    @NotNull
    @Column(name = "uuid_attribute", nullable = false, length = 40,unique = true)
    private String uuidAttribute;

    @Size(max = 40)
    @NotNull
    @Id
    @Column(name = "uuid_product", nullable = false, length = 40,unique = true)
    private String uuidProduct;

    @Size(max = 200)
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