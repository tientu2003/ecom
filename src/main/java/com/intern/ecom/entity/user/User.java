package com.intern.ecom.entity.user;

import com.intern.ecom.entity.product.Branch;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;


@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "uuid_user", nullable = false, length = 40)
    private String uuidUser;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_user", nullable = false, referencedColumnName = "uuid_user")
    private Branch branch;

    @Column(name = "uuid_cart", nullable = false, length = 40)
    private String uuidCart;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "mobile", length = 15)
    private String mobile;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "avatar", length = 200)
    private String avatar;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "password", nullable = false, length = 32)
    private String password;

    @ColumnDefault("0")
    @Column(name = "admin", nullable = false)
    private Short admin;

    @Column(name = "register_date", nullable = false)
    private Timestamp registerDate;

    @Column(name = "last_login")
    private Timestamp lastLogin;

    @ColumnDefault("0")
    @Column(name = "activate")
    private Short activate;

    public String getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(String uuidUser) {
        this.uuidUser = uuidUser;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getUuidCart() {
        return uuidCart;
    }

    public void setUuidCart(String uuidCart) {
        this.uuidCart = uuidCart;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getAdmin() {
        return admin;
    }

    public void setAdmin(Short admin) {
        this.admin = admin;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Short getActivate() {
        return activate;
    }

    public void setActivate(Short activate) {
        this.activate = activate;
    }

}