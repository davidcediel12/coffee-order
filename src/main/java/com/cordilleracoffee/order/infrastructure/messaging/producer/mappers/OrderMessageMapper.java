package com.cordilleracoffee.order.infrastructure.messaging.producer.mappers;

import com.cordilleracoffee.order.domain.model.Order;
import com.cordilleracoffee.order.infrastructure.messaging.producer.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMessageMapper {


    OrderDto toOrderMessage(Order order);
}
