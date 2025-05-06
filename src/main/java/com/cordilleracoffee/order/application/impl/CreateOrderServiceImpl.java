package com.cordilleracoffee.order.application.impl;


import com.cordilleracoffee.order.application.CreateOrderService;
import com.cordilleracoffee.order.application.mapper.OrderMapper;
import com.cordilleracoffee.order.domain.model.Order;
import com.cordilleracoffee.order.domain.model.OrderItem;
import com.cordilleracoffee.order.domain.repository.OrderItemRepository;
import com.cordilleracoffee.order.domain.repository.OrderRepository;
import com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto.CheckoutPerformed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CreateOrderServiceImpl implements CreateOrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public void createOrder(CheckoutPerformed checkoutPerformed) {

        Order order = orderMapper.toDomain(checkoutPerformed);

        List<OrderItem> orderItems = new ArrayList<>(order.getOrderItems());

        order = orderRepository.save(order);

        for (var orderItem : orderItems) {
            orderItem.setId(UUID.randomUUID());
            orderItem.setOrder(order);
        }
        orderItemRepository.saveAll(orderItems);

        log.info("Order {} was created successfully", order.getId());
    }
}
