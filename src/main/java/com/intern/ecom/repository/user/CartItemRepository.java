package com.intern.ecom.repository.user;

import com.intern.ecom.entity.user.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, String> {
}