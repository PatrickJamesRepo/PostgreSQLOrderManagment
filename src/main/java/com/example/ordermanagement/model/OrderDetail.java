package com.example.ordermanagement.model;

import javax.persistence.*;

@Entity
public class OrderDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderDetailId;
  
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;
  
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
  
  private Integer quantity;
  private Double price;

  // Getters and Setters
  public Long getOrderDetailId() { return orderDetailId; }
  public void setOrderDetailId(Long orderDetailId) { this.orderDetailId = orderDetailId; }
  public Order getOrder() { return order; }
  public void setOrder(Order order) { this.order = order; }
  public Product getProduct() { return product; }
  public void setProduct(Product product) { this.product = product; }
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }
  public Double getPrice() { return price; }
  public void setPrice(Double price) { this.price = price; }
}
