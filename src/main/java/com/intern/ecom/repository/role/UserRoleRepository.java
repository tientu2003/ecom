package com.intern.ecom.repository.role;

import com.intern.ecom.entity.role.UserRole;
import com.intern.ecom.entity.role.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}