package com.intern.ecom.entity.category;

import com.intern.ecom.entity.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductCategoryId implements Serializable {
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_product", nullable = false,unique = true)
    private Product uuidProduct;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_category", nullable = false)
    private Category uuidCategory;

    public ProductCategoryId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryId that = (ProductCategoryId) o;
        return Objects.equals(uuidProduct, that.uuidProduct) && Objects.equals(uuidCategory, that.uuidCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuidProduct, uuidCategory);
    }

    public @NotNull Product getUuidProduct() {
        return uuidProduct;
    }

    public ProductCategoryId setUuidProduct(@NotNull Product uuidProduct) {
        this.uuidProduct = uuidProduct;
        return this;
    }

    public @NotNull Category getUuidCategory() {
        return uuidCategory;
    }

    public ProductCategoryId setUuidCategory(@NotNull Category uuidCategory) {
        this.uuidCategory = uuidCategory;
        return this;
    }
}
