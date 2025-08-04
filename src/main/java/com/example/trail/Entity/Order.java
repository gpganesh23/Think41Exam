package com.example.trail.Entity;


import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    private Long orderId;
    
    @Column(name = "user_id")
    private Long userId;
    
    private String status;
    private Character gender;
    
    @Column(name = "created_at")
    private Timestamp createdAt;
    
    @Column(name = "returned_at")
    private Timestamp returnedAt;
    
    @Column(name = "shipped_at")
    private Timestamp shippedAt;
    
    @Column(name = "delivered_at")
    private Timestamp deliveredAt;
    
    @Column(name = "num_of_item")
    private Integer numOfItem;

    // Getters and Setters
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Character getGender() { return gender; }
    public void setGender(Character gender) { this.gender = gender; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public Timestamp getReturnedAt() { return returnedAt; }
    public void setReturnedAt(Timestamp returnedAt) { this.returnedAt = returnedAt; }

    public Timestamp getShippedAt() { return shippedAt; }
    public void setShippedAt(Timestamp shippedAt) { this.shippedAt = shippedAt; }

    public Timestamp getDeliveredAt() { return deliveredAt; }
    public void setDeliveredAt(Timestamp deliveredAt) { this.deliveredAt = deliveredAt; }

    public Integer getNumOfItem() { return numOfItem; }
    public void setNumOfItem(Integer numOfItem) { this.numOfItem = numOfItem; }
}

//