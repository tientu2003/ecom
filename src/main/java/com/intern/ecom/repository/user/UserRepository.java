package com.intern.ecom.repository.user;

import com.intern.ecom.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
  public Optional<User> findByEmail(String email);
  }