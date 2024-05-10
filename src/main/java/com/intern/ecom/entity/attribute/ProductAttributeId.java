package com.intern.ecom.entity.attribute;

import java.io.Serializable;
import java.util.Objects;

public class ProductAttributeId implements Serializable {
    private String uuidProduct;
    private String uuidAttribute;
    public ProductAttributeId() {}
    public ProductAttributeId(String uuidProduct, String uuidAttribute) {
        this.uuidProduct = uuidProduct;
        this.uuidAttribute = uuidAttribute;
    }

    public String getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(String uuidProduct) {
        this.uuidProduct = uuidProduct;
    }

    public String getUuidAttribute() {
        return uuidAttribute;
    }

    public void setUuidAttribute(String uuidAttribute) {
        this.uuidAttribute = uuidAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAttributeId that = (ProductAttributeId) o;
        return Objects.equals(uuidProduct, that.uuidProduct) && Objects.equals(uuidAttribute, that.uuidAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuidProduct, uuidAttribute);
    }
}
