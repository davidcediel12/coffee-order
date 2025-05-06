package com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CheckoutEventType {
    ORDER_PLACED;

    @JsonCreator
    public static CheckoutEventType fromValue(String value) {
        try {
            return CheckoutEventType.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
