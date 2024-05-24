package com.intern.ecom.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intern.ecom.entity.attribute.ProductAttribute;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Size(max = 40)
    @Column(name = "uuid_product", nullable = false, length = 40)
    private String uuidProduct;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_product", nullable = false, referencedColumnName = "uuid_product")
    @JsonIgnore
    private ProductAttribute productAttribute;

    @Size(max = 75)
    @NotNull
    @Column(name = "title", nullable = false, length = 75)
    private String title;

    @Size(max = 100)
    @Column(name = "meta_title", length = 100)
    private String metaTitle;

    @Lob
    @Column(name = "summary")
    private String summary;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "type", nullable = false)
    private Short type;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @Column(name = "published_date")
    private Instant publishedDate;

    @Lob
    @Column(name = "description")
    private String description;

    @Size(max = 40)
    @NotNull
    @Column(name = "uuid_branch", nullable = false, length = 40)
    private String uuidBranch;

    public Product() {

    }

    public Product(ProductAttribute productAttribute,String title,
                   Short type, Double price,
                   Short quantity, Instant createdDate,
                   String uuidBranch) {
        this.uuidProduct = productAttribute.getUuidProduct();
        this.productAttribute = productAttribute;
        this.title = title;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.createdDate = createdDate;
        this.uuidBranch = uuidBranch;
    }


    public String getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(String uuidProduct) {
        this.uuidProduct = uuidProduct;
    }

    public ProductAttribute getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(ProductAttribute productAttribute) {
        this.productAttribute = productAttribute;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Instant getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Instant publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUuidBranch() {
        return uuidBranch;
    }

    public void setUuidBranch(String uuidBranch) {
        this.uuidBranch = uuidBranch;
    }



}