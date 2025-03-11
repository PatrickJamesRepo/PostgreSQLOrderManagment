package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Product;
import com.example.ordermanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  // CREATE - Add a new product
  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }

  // READ - Return all products
  @GetMapping
  public List<Product> listProducts() {
    return productRepository.findAll();
  }

  // READ - Return products by category
  @GetMapping("/category/{category}")
  public List<Product> productsByCategory(@PathVariable String category) {
    return productRepository.findByCategory(category);
  }

  // READ - Return product details by ID
  @GetMapping("/{id}")
  public Product productDetail(@PathVariable Long id) {
    return productRepository.findById(id).orElse(null);
  }

  // UPDATE - Update an existing product
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
    return productRepository.findById(id)
            .map(product -> {
              product.setName(updatedProduct.getName());
              product.setDescription(updatedProduct.getDescription());
              product.setCategory(updatedProduct.getCategory());
              product.setPrice(updatedProduct.getPrice());
              product.setQuantityAvailable(updatedProduct.getQuantityAvailable());
              product.setRating(updatedProduct.getRating());
              return productRepository.save(product);
            })
            .orElse(null);
  }

  // DELETE - Remove a product by ID
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productRepository.deleteById(id);
  }
}
