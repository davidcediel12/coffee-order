package com.cordilleracoffee.order.infrastructure.messaging.producer;

import com.cordilleracoffee.order.application.port.OrderEventSender;
import com.cordilleracoffee.order.domain.model.Order;
import com.cordilleracoffee.order.domain.model.OrderEvent;
import com.cordilleracoffee.order.infrastructure.messaging.producer.dto.OrderMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventSenderImpl implements OrderEventSender {

    private static final String ORDER_TOPIC = "order";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void sendNewOrder(Order order) {

        MessageHeaders headers = new MessageHeaders(Map.of(
                KafkaHeaders.TOPIC, ORDER_TOPIC,
                MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));


        try {
            kafkaTemplate.send(new GenericMessage<>(objectMapper.writeValueAsString(
                    new OrderMessage(OrderEvent.ORDER_CREATED, order)),
                    headers));

        } catch (JsonProcessingException e) {
            log.error("Error serializing order message", e);
            throw new RuntimeException(e);
        }
    }
}
