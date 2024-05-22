package com.intern.ecom.repository.order;

import com.intern.ecom.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}