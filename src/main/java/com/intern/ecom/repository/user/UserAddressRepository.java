package com.intern.ecom.repository.user;

import com.intern.ecom.entity.user.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, String> {
}