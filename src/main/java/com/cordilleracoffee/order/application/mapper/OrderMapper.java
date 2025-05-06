package com.cordilleracoffee.order.application.mapper;

import com.cordilleracoffee.order.domain.model.Order;
import com.cordilleracoffee.order.domain.model.OrderItem;
import com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto.CartItemWithDetails;
import com.cordilleracoffee.order.infrastructure.messaging.consumer.checkout.dto.CheckoutPerformed;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", source = "orderId")
    @Mapping(target = "cartId", source = "cartSnapshot.cartId")
    @Mapping(target = "userId", source = "cartSnapshot.userId")
    @Mapping(target = "currency", source = "cartSnapshot.currency")
    @Mapping(target = "price", source = "cartSnapshot.price")
    @Mapping(target = "orderItems", source = "cartSnapshot.items")
    Order toDomain(CheckoutPerformed checkoutPerformed);


    @Mapping(target = "order", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "unitPrice", source = "finalBasePrice")
    @Mapping(target = "discountId", source = "discount.discountId")
    @Mapping(target = "imageUrl", source = "primaryImageUrl")
    OrderItem toDomainItem(CartItemWithDetails item);

}
