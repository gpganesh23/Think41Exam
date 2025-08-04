package com.example.trail.DTO;

import java.time.Instant; // Updated import to use modern Java time API

import com.example.trail.Entity.User;

public class UserWithOrderCountDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Character gender;
    private String state;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    private String trafficSource;
    private Instant createdAt; // Updated field type to Instant
    private Long orderCount;

    // No-argument constructor
    public UserWithOrderCountDto() {
    }

    // Constructor to map User entity to DTO and add order count
    public UserWithOrderCountDto(User user, Long orderCount) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.state = user.getState();
        this.streetAddress = user.getStreetAddress();
        this.postalCode = user.getPostalCode();
        this.city = user.getCity();
        this.country = user.getCountry();
        this.latitude = user.getLatitude();
        this.longitude = user.getLongitude();
        this.trafficSource = user.getTrafficSource();
        this.createdAt = user.getCreatedAt(); // The User entity now returns Instant
        this.orderCount = orderCount;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    
    public Character getGender() { return gender; }
    public void setGender(Character gender) { this.gender = gender; }
    
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    
    public String getStreetAddress() { return streetAddress; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    
    public String getTrafficSource() { return trafficSource; }
    public void setTrafficSource(String trafficSource) { this.trafficSource = trafficSource; }
    
    public Instant getCreatedAt() { return createdAt; } // Updated getter method
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; } // Updated setter method

    public Long getOrderCount() { return orderCount; }
    public void setOrderCount(Long orderCount) { this.orderCount = orderCount; }
}
