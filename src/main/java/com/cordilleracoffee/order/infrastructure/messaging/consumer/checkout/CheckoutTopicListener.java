package com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout;


import com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto.CheckoutEventType;
import com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto.CheckoutMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CheckoutTopicListener {

    private final ObjectMapper objectMapper;


    @KafkaListener(groupId = "order", topics = "checkout")
    public void consume(GenericMessage<String> message) {
        log.info("Received Message from stock topic: {}", message.getPayload());
        CheckoutMessage checkoutMessage;

        try {
            checkoutMessage = objectMapper.readValue(message.getPayload(), CheckoutMessage.class);

            CheckoutEventType eventType = checkoutMessage.checkoutEventType();

            if (eventType == null) {
                return;
            }

        } catch (JsonProcessingException e) {
            log.error("Unable to parse message", e);
            throw new RuntimeException(e);
        }
    }
}
