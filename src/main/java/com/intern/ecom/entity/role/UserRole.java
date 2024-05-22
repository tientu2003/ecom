package com.intern.ecom.entity.role;

import com.intern.ecom.entity.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @EmbeddedId
    private UserRoleId id;

    @MapsId("uuidUser")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_user", nullable = false)
    private User uuidUser;

    public UserRoleId getId() {
        return id;
    }

    public void setId(UserRoleId id) {
        this.id = id;
    }

    public User getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(User uuidUser) {
        this.uuidUser = uuidUser;
    }

}