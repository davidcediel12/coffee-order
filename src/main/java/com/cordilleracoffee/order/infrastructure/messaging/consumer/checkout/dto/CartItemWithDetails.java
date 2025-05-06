package com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto;

import java.math.BigDecimal;

public record CartItemWithDetails(Long productId, Long variantId, Long categoryId, Integer quantity,
                                  BigDecimal finalBasePrice, ItemDiscount discount,
                                  String name, String description,
                                  String sku, String primaryImageUrl, boolean isVariant) {

}
