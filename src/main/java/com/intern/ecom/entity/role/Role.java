package com.intern.ecom.entity.role;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "uuid_role", nullable = false, length = 40)
    private String uuidRole;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_role", nullable = false, referencedColumnName = "uuid_role")
    private UserRole userRole;

    @Column(name = "name")
    private Integer name;

    public String getUuidRole() {
        return uuidRole;
    }

    public void setUuidRole(String uuidRole) {
        this.uuidRole = uuidRole;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

}