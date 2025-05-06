package com.cordilleracoffee.order.infrastructure.persistence.repository.impl;

import com.cordilleracoffee.order.domain.model.Order;
import com.cordilleracoffee.order.domain.repository.OrderRepository;
import com.cordilleracoffee.order.infrastructure.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
@RequiredArgsConstructor
@Transactional(propagation = Propagation.MANDATORY)
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order save(Order order) {
        return orderJpaRepository.save(order);
    }


}
