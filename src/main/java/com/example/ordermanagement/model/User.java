package com.example.ordermanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;
  
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  
  // Address fields
  private String city;
  private String street;
  private String landmark;
  private String state;
  private String pin;
  private String phoneNumber;

  // Getters and Setters
  public Long getUserId() { return userId; }
  public void setUserId(Long userId) { this.userId = userId; }
  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }
  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }
  public String getCity() { return city; }
  public void setCity(String city) { this.city = city; }
  public String getStreet() { return street; }
  public void setStreet(String street) { this.street = street; }
  public String getLandmark() { return landmark; }
  public void setLandmark(String landmark) { this.landmark = landmark; }
  public String getState() { return state; }
  public void setState(String state) { this.state = state; }
  public String getPin() { return pin; }
  public void setPin(String pin) { this.pin = pin; }
  public String getPhoneNumber() { return phoneNumber; }
  public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
