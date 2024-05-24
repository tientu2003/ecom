package com.intern.ecom.entity.category;

import com.intern.ecom.entity.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    private ProductCategoryId id;

    public ProductCategoryId getId() {
        return id;
    }

    public void setId(ProductCategoryId id) {
        this.id = id;
    }


}