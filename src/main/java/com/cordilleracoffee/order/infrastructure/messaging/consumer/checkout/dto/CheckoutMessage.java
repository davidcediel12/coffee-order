package com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public record CheckoutMessage(@JsonProperty("eventType") CheckoutEventType checkoutEventType,
                              JsonNode content) {
}
