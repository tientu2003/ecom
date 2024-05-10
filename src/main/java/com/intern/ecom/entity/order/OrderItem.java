package com.intern.ecom.entity.order;

import com.intern.ecom.entity.product.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @Column(name = "uuid_order_item", nullable = false, length = 40)
    private String uuidOrderItem;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_product", nullable = false)
    private Product uuidProduct;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_order", nullable = false)
    private Order uuidOrder;

    @ColumnDefault("0")
    @Column(name = "price", nullable = false)
    private Double price;

    @ColumnDefault("0")
    @Column(name = "discount", nullable = false)
    private Double discount;

    @ColumnDefault("0")
    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Lob
    @Column(name = "content")
    private String content;

    public String getUuidOrderItem() {
        return uuidOrderItem;
    }

    public void setUuidOrderItem(String uuidOrderItem) {
        this.uuidOrderItem = uuidOrderItem;
    }

    public Product getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(Product uuidProduct) {
        this.uuidProduct = uuidProduct;
    }

    public Order getUuidOrder() {
        return uuidOrder;
    }

    public void setUuidOrder(Order uuidOrder) {
        this.uuidOrder = uuidOrder;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}