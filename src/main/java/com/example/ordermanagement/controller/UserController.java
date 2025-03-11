package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.User;
import com.example.ordermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  // CREATE - Register a new user
  @PostMapping
  public User register(@RequestBody User user) {
    return userRepository.save(user);
  }

  // READ - Return all users
  @GetMapping
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  // READ - Return user details by ID
  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return userRepository.findById(id).orElse(null);
  }

  // UPDATE - Update an existing user
  @PutMapping("/{id}")
  public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
    return userRepository.findById(id)
            .map(user -> {
              user.setUsername(updatedUser.getUsername());
              user.setPassword(updatedUser.getPassword());
              user.setFirstName(updatedUser.getFirstName());
              user.setLastName(updatedUser.getLastName());
              user.setCity(updatedUser.getCity());
              user.setStreet(updatedUser.getStreet());
              user.setLandmark(updatedUser.getLandmark());
              user.setState(updatedUser.getState());
              user.setPin(updatedUser.getPin());
              user.setPhoneNumber(updatedUser.getPhoneNumber());
              return userRepository.save(user);
            })
            .orElse(null);
  }

  // DELETE - Remove a user by ID
  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
  }
}
