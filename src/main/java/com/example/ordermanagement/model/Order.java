package com.example.ordermanagement.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;
  
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  
  private LocalDateTime orderDate;
  private String status;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderDetail> orderDetails;

  // Getters and Setters
  public Long getOrderId() { return orderId; }
  public void setOrderId(Long orderId) { this.orderId = orderId; }
  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }
  public LocalDateTime getOrderDate() { return orderDate; }
  public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  public List<OrderDetail> getOrderDetails() { return orderDetails; }
  public void setOrderDetails(List<OrderDetail> orderDetails) { this.orderDetails = orderDetails; }
}
