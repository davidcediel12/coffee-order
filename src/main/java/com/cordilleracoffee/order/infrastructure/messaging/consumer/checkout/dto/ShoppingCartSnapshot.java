package com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record ShoppingCartSnapshot(UUID cartId, String userId, String currency, BigDecimal price,
                                   List<CartItemWithDetails> items) {
}
