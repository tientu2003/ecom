package com.intern.ecom.entity.order;

import com.intern.ecom.entity.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;


@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @Column(name = "uuid_order", nullable = false, length = 40)
    private String uuidOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "session_id", nullable = false, length = 100)
    private String sessionId;

    @Column(name = "token", nullable = false, length = 100)
    private String token;

    @ColumnDefault("0")
    @Column(name = "status", nullable = false)
    private Short status;

    @ColumnDefault("0")
    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @ColumnDefault("0")
    @Column(name = "item_discount", nullable = false)
    private Double itemDiscount;

    @ColumnDefault("0")
    @Column(name = "tax", nullable = false)
    private Double tax;

    @ColumnDefault("0")
    @Column(name = "shipping", nullable = false)
    private Double shipping;

    @ColumnDefault("0")
    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "promo", length = 50)
    private String promo;

    @ColumnDefault("0")
    @Column(name = "discount", nullable = false)
    private Double discount;

    @ColumnDefault("0")
    @Column(name = "grand_total", nullable = false)
    private Double grandTotal;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "payment_methods", length = 10)
    private String paymentMethods;

    @Lob
    @Column(name = "note")
    private String note;

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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
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