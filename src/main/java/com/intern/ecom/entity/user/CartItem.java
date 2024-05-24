package com.intern.ecom.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @Size(max = 40)
    @Column(name = "uuid_cart_item", nullable = false, length = 40)
    private String uuidCartItem;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_cart", nullable = false, referencedColumnName = "uuid_cart")
    private User uuidCart;

    @Size(max = 40)
    @Column(name = "uuid_product", length = 40)
    private String uuidProduct;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "discount", nullable = false)
    private Double discount;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "active", nullable = false)
    private Short active;

    @Lob
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @Column(name = "updated_date")
    private Instant updatedDate;

    public String getUuidCartItem() {
        return uuidCartItem;
    }

    public void setUuidCartItem(String uuidCartItem) {
        this.uuidCartItem = uuidCartItem;
    }

    public User getUuidCart() {
        return uuidCart;
    }

    public void setUuidCart(User uuidCart) {
        this.uuidCart = uuidCart;
    }

    public String getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(String uuidProduct) {
        this.uuidProduct = uuidProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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