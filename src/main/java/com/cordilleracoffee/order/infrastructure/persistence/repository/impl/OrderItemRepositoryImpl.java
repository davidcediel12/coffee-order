package com.cordilleracoffee.order.infrastructure.persistence.repository.impl;

import com.cordilleracoffee.order.domain.model.OrderItem;
import com.cordilleracoffee.order.domain.repository.OrderItemRepository;
import com.cordilleracoffee.order.infrastructure.persistence.repository.OrderItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
@RequiredArgsConstructor
public class OrderItemRepositoryImpl implements OrderItemRepository {


    private final OrderItemJpaRepository orderItemJpaRepository;

    @Override
    public List<OrderItem> saveAll(Iterable<OrderItem> orderItems) {
        return orderItemJpaRepository.saveAll(orderItems);
    }
}
