package com.cordilleracoffee.order.infrastructure.messaging.producer.dto;

import com.cordilleracoffee.order.domain.model.OrderEvent;

public record OrderMessage(OrderEvent orderEvent, Object content) {
}
