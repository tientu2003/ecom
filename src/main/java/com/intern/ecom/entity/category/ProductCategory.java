package com.intern.ecom.entity.category;

import com.intern.ecom.entity.product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_product", nullable = false,unique = true)
    private Product uuidProduct;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_category", nullable = false,unique = true)
    private Category uuidCategory;

    public Product getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(Product uuidProduct) {
        this.uuidProduct = uuidProduct;
    }

    public Category getUuidCategory() {
        return uuidCategory;
    }

    public void setUuidCategory(Category uuidCategory) {
        this.uuidCategory = uuidCategory;
    }

}