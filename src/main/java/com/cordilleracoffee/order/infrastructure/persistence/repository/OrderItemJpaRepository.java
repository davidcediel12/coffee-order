package com.cordilleracoffee.order.infrastructure.persistence.repository;

import com.cordilleracoffee.order.domain.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemJpaRepository extends JpaRepository<OrderItem, UUID> {
}