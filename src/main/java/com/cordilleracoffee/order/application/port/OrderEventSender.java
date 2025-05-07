package com.cordilleracoffee.order.application.port;

import com.cordilleracoffee.order.domain.model.Order;

public interface OrderEventSender {
    void sendNewOrder(Order order);
}
