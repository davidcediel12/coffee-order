package com.cordilleracoffee.order.domain.repository;

import com.cordilleracoffee.order.domain.model.OrderItem;

import java.util.List;

public interface OrderItemRepository {
    List<OrderItem> saveAll(Iterable<OrderItem> orderItems);
}
