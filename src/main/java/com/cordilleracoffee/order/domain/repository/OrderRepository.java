package com.cordilleracoffee.order.domain.repository;

import com.cordilleracoffee.order.domain.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
