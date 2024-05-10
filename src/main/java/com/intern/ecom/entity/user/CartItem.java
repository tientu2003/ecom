package com.intern.ecom.entity.user;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @Column(name = "uuid_cart_item", nullable = false, length = 40)
    private String uuidCartItem;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_cart", nullable = false, referencedColumnName = "uuid_cart")
    private User uuidCart;

    @Column(name = "uuid_product", length = 40)
    private String uuidProduct;

    @ColumnDefault("0")
    @Column(name = "price", nullable = false)
    private Double price;

    @ColumnDefault("0")
    @Column(name = "discount", nullable = false)
    private Double discount;

    @ColumnDefault("0")
    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @ColumnDefault("0")
    @Column(name = "active", nullable = false)
    private Short active;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

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

}