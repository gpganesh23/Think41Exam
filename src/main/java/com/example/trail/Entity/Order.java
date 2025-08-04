package com.example.trail.Entity;


import java.time.Instant;

import com.example.trail.coverter.InstantToStringConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    // Use @JsonIgnore to prevent serialization of the lazy-loaded proxy.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    private String status;

    @Column(name = "product")
    private String product;

    @Column(name = "order_amount")
    private Double orderAmount;

    // Use the new converter to handle string-based timestamps.
    @Convert(converter = InstantToStringConverter.class)
    @Column(name = "shipped_at", nullable = true)
    private Instant shippedAt;

    @Convert(converter = InstantToStringConverter.class)
    @Column(name = "delivered_at", nullable = true)
    private Instant deliveredAt;

    @Convert(converter = InstantToStringConverter.class)
    @Column(name = "returned_at", nullable = true)
    private Instant returnedAt;
    
    public Order() {}

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
    public Double getOrderAmount() { return orderAmount; }
    public void setOrderAmount(Double orderAmount) { this.orderAmount = orderAmount; }
    public Instant getShippedAt() { return shippedAt; }
    public void setShippedAt(Instant shippedAt) { this.shippedAt = shippedAt; }
    
    public Instant getDeliveredAt() { return deliveredAt; }
    public void setDeliveredAt(Instant deliveredAt) { this.deliveredAt = deliveredAt; }
    
    public Instant getReturnedAt() { return returnedAt; }
    public void setReturnedAt(Instant returnedAt) { this.returnedAt = returnedAt; }
}
