package com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto;


import java.util.UUID;

public record CheckoutPerformed(UUID orderId, UUID paymentId, String paymentStatus,
                                ShoppingCartSnapshot cartSnapshot) {


}
