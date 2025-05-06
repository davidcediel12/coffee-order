package com.cordilleracoffee.order.application;

import com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto.CheckoutPerformed;

public interface CreateOrderService {
    void createOrder(CheckoutPerformed checkoutPerformed);
}
