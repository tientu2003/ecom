package com.intern.ecom.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_address")
public class UserAddress {
    @Id
    @Size(max = 40)
    @Column(name = "uuid_address", nullable = false, length = 40)
    private String uuidAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuid_user")
    private User uuidUser;

    @Size(max = 15)
    @Column(name = "mobile", length = 15)
    private String mobile;

    @Size(max = 255)
    @Column(name = "city")
    private String city;

    @Size(max = 255)
    @Column(name = "street")
    private String street;

    @Size(max = 255)
    @Column(name = "district")
    private String district;

    @Column(name = "postal_code")
    private Integer postalCode;

    public String getUuidAddress() {
        return uuidAddress;
    }

    public void setUuidAddress(String uuidAddress) {
        this.uuidAddress = uuidAddress;
    }

    public User getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(User uuidUser) {
        this.uuidUser = uuidUser;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

}