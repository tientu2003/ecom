package com.intern.ecom.entity.product;

import com.intern.ecom.entity.attribute.ProductAttribute;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "uuid_product", nullable = false, length = 40,unique = true)
    private String uuidProduct;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_product", nullable = false, referencedColumnName = "uuid_product")
    private ProductAttribute productAttribute;

    @Column(name = "title", nullable = false, length = 75)
    private String title;

    @Column(name = "meta_title", length = 100)
    private String metaTitle;

    @Lob
    @Column(name = "summary")
    private String summary;

    @ColumnDefault("0")
    @Column(name = "type", nullable = false)
    private Short type;

    @ColumnDefault("0")
    @Column(name = "price", nullable = false)
    private Double price;

    @ColumnDefault("0")
    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "published_date")
    private Timestamp publishedDate;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "uuid_branch", nullable = false, length = 40)
    private String uuidBranch;

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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Timestamp getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Timestamp publishedDate) {
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