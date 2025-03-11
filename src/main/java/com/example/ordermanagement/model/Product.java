package com.example.ordermanagement.model;

import javax.persistence.*;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;
  
  private String name;
  private String description;
  private String category;
  private Double price;
  private Integer quantityAvailable;
  private Double rating;

  // Getters and Setters
  public Long getProductId() { return productId; }
  public void setProductId(Long productId) { this.productId = productId; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }
  public Double getPrice() { return price; }
  public void setPrice(Double price) { this.price = price; }
  public Integer getQuantityAvailable() { return quantityAvailable; }
  public void setQuantityAvailable(Integer quantityAvailable) { this.quantityAvailable = quantityAvailable; }
  public Double getRating() { return rating; }
  public void setRating(Double rating) { this.rating = rating; }
}
