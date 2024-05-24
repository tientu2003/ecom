package com.intern.ecom.repository.user;

import com.intern.ecom.entity.user.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, String> {
    public Optional<List<CartItem>> findAllByUuidCart_UuidCart(String cartId);
}