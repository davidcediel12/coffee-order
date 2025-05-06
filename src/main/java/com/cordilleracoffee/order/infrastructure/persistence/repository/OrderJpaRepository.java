package com.cordilleracoffee.order.infrastructure.persistence.repository;

import com.cordilleracoffee.order.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<Order, UUID> {
}