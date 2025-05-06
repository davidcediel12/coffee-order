package com.cordilleracoffee.order.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private UUID paymentId;

    private String paymentStatus;

    private UUID cartId;

    private String userId;

    private String currency;
    private BigDecimal price;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;

    @CreationTimestamp
    private Instant createdAt;

}