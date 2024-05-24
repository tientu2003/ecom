package com.intern.ecom.entity.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @Size(max = 40)
    @Column(name = "uuid_branch", nullable = false, length = 40)
    private String uuidBranch;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_branch", nullable = false, referencedColumnName = "uuid_branch")
    private Product product;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Size(max = 40)
    @NotNull
    @Column(name = "uuid_user", nullable = false, length = 40)
    private String uuidUser;

    public String getUuidBranch() {
        return uuidBranch;
    }

    public void setUuidBranch(String uuidBranch) {
        this.uuidBranch = uuidBranch;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(String uuidUser) {
        this.uuidUser = uuidUser;
    }

}