package com.intern.ecom.entity.order;

import com.intern.ecom.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @Size(max = 40)
    @Column(name = "uuid_order", nullable = false, length = 40)
    private String uuidOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Size(max = 100)
    @NotNull
    @Column(name = "session_id", nullable = false, length = 100)
    private String sessionId;

    @Size(max = 100)
    @NotNull
    @Column(name = "token", nullable = false, length = 100)
    private String token;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "status", nullable = false)
    private Short status;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "item_discount", nullable = false)
    private Double itemDiscount;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "tax", nullable = false)
    private Double tax;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "shipping", nullable = false)
    private Double shipping;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "total", nullable = false)
    private Double total;

    @Size(max = 50)
    @Column(name = "promo", length = 50)
    private String promo;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "discount", nullable = false)
    private Double discount;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "grand_total", nullable = false)
    private Double grandTotal;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @Size(max = 20)
    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @Size(max = 10)
    @Column(name = "payment_methods", length = 10)
    private String paymentMethods;

    @Lob
    @Column(name = "note")
    private String note;

    @Size(max = 1000)
    @Column(name = "address_ship", length = 1000)
    private String addressShip;

    public String getUuidOrder() {
        return uuidOrder;
    }

    public void setUuidOrder(String uuidOrder) {
        this.uuidOrder = uuidOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(Double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getShipping() {
        return shipping;
    }

    public void setShipping(Double shipping) {
        this.shipping = shipping;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAddressShip() {
        return addressShip;
    }

    public void setAddressShip(String addressShip) {
        this.addressShip = addressShip;
    }

}