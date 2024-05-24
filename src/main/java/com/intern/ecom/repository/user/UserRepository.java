package com.intern.ecom.repository.user;

import com.intern.ecom.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}