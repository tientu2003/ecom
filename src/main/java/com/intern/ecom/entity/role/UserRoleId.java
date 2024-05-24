package com.intern.ecom.entity.role;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserRoleId implements Serializable {
    private static final long serialVersionUID = -382827789583125841L;
    @Size(max = 40)
    @NotNull
    @Column(name = "uuid_role", nullable = false, length = 40)
    private String uuidRole;

    @Size(max = 40)
    @NotNull
    @Column(name = "uuid_user", nullable = false, length = 40)
    private String uuidUser;

    public String getUuidRole() {
        return uuidRole;
    }

    public void setUuidRole(String uuidRole) {
        this.uuidRole = uuidRole;
    }

    public String getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(String uuidUser) {
        this.uuidUser = uuidUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserRoleId entity = (UserRoleId) o;
        return Objects.equals(this.uuidRole, entity.uuidRole) &&
                Objects.equals(this.uuidUser, entity.uuidUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuidRole, uuidUser);
    }

}