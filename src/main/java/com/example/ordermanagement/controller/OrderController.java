package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderRepository orderRepository;

  // CREATE - Place a new order
  @PostMapping
  public Order placeOrder(@RequestBody Order order) {
    return orderService.placeOrder(order);
  }

  // READ - Get all orders
  @GetMapping
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  // READ - Get a specific order by ID
  @GetMapping("/{id}")
  public Order getOrderById(@PathVariable Long id) {
    return orderRepository.findById(id).orElse(null);
  }

  // UPDATE - Update an existing order (e.g., status)
  @PutMapping("/{id}")
  public Order updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
    return orderRepository.findById(id)
            .map(order -> {
              order.setStatus(updatedOrder.getStatus());
              return orderRepository.save(order);
            })
            .orElse(null);
  }

  // DELETE - Remove an order by ID
  @DeleteMapping("/{id}")
  public void deleteOrder(@PathVariable Long id) {
    orderRepository.deleteById(id);
  }
}
