package com.intern.ecom.entity.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "product_review")
public class ProductReview {
    @Id
    @Size(max = 40)
    @Column(name = "uuid_product_review", nullable = false, length = 40)
    private String uuidProductReview;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuid_product")
    private Product uuidProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuid_parent_product_review")
    private ProductReview uuidParentProductReview;

    @Lob
    @Column(name = "comment")
    private String comment;

    @Size(max = 100)
    @NotNull
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "rating", nullable = false)
    private Short rating;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "published", nullable = false)
    private Short published;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @Column(name = "updated_date")
    private Instant updatedDate;

    public String getUuidProductReview() {
        return uuidProductReview;
    }

    public void setUuidProductReview(String uuidProductReview) {
        this.uuidProductReview = uuidProductReview;
    }

    public Product getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(Product uuidProduct) {
        this.uuidProduct = uuidProduct;
    }

    public ProductReview getUuidParentProductReview() {
        return uuidParentProductReview;
    }

    public void setUuidParentProductReview(ProductReview uuidParentProductReview) {
        this.uuidParentProductReview = uuidParentProductReview;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    public Short getPublished() {
        return published;
    }

    public void setPublished(Short published) {
        this.published = published;
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

}