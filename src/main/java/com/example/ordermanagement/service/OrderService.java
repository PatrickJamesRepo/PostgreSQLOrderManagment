package com.example.ordermanagement.service;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.Product;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private OrderRepository orderRepository;

  public boolean isProductAvailable(Long productId, int requestedQuantity) {
    Product product = productRepository.findById(productId).orElse(null);
    return product != null && product.getQuantityAvailable() >= requestedQuantity;
  }

  // Place order
  public Order placeOrder(Order order) {
    order.setOrderDate(LocalDateTime.now());
    order.setStatus("PLACED");
    return orderRepository.save(order);
  }
}
