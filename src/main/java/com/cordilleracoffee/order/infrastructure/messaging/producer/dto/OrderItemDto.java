package com.cordilleracoffee.order.infrastructure.messaging.producer.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemDto(
        UUID id,
        Long productId,
        Long variantId,
        Long categoryId,
        Integer quantity,
        BigDecimal unitPrice,
        UUID discountId,
        String name,
        String description,
        String sku,
        String imageUrl,
        Boolean isVariant) {
}
