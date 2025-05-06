package com.cordilleracoffee.order.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    private Order order;

    private Long productId;
    private Long variantId;
    private Long categoryId;

    private Integer quantity;
    private BigDecimal unitPrice;
    private UUID discountId;

    private String name;
    private String description;
    private String sku;
    private String imageUrl;
    private Boolean isVariant;


}