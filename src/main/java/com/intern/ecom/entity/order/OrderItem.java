package com.intern.ecom.entity.order;

import com.intern.ecom.entity.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @Size(max = 40)
    @Column(name = "uuid_order_item", nullable = false, length = 40)
    private String uuidOrderItem;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_product", nullable = false)
    private Product uuidProduct;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_order", nullable = false)
    private Order uuidOrder;

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
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @Column(name = "updated_date")
    private Instant updatedDate;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}