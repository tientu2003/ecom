package com.intern.ecom.repository.role;

import com.intern.ecom.entity.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}