package com.RestaurantRegister.Restaurant.Validation;

import com.RestaurantRegister.Restaurant.Models.dto.Request.CreateRestaurantRequest;
import com.RestaurantRegister.Restaurant.Utils.Address;

public class CreateRestaurantRequestValidation {

    public static CreateRestaurantRequest validate(CreateRestaurantRequest createRestaurantRequest) {
        if (createRestaurantRequest.getRestaurantName() == null || createRestaurantRequest.getRestaurantName().isEmpty()) {
            throw new IllegalArgumentException("Restaurant name cannot be empty");
        }
        if (createRestaurantRequest.getUserName() == null || createRestaurantRequest.getUserName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (createRestaurantRequest.getPassword() == null || createRestaurantRequest.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if (createRestaurantRequest.getPhoneNumber() == null || createRestaurantRequest.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        if (createRestaurantRequest.getEmail() == null || createRestaurantRequest.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (createRestaurantRequest.getOwnerName() == null || createRestaurantRequest.getOwnerName().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }
        if (createRestaurantRequest.getOwnerPhoneNumber() == null || createRestaurantRequest.getOwnerPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("Owner phone number cannot be empty");
        }
        if (createRestaurantRequest.getOwnerEmail() == null || createRestaurantRequest.getOwnerEmail().isEmpty()) {
            throw new IllegalArgumentException("Owner email cannot be empty");
        }
        validatePassword(createRestaurantRequest.getPassword());
        validatePhoneNumber(createRestaurantRequest.getOwnerPhoneNumber());
        validatePhoneNumber(createRestaurantRequest.getPhoneNumber());
        validateEmail(createRestaurantRequest.getEmail());
        validateEmail(createRestaurantRequest.getOwnerEmail());
        validateUserName(createRestaurantRequest.getUserName());
        return createRestaurantRequest;
    }

    public static void validateUserName(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
    }

    public static void validateEmail(String email) {
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public static void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }

    public static void validatePassword(String password) {
        if (password.length() < 7 || password.length() > 15) {
            throw new IllegalArgumentException("Password should be between 7 and 15 characters");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password should contain at least one digit");
        }
        if (!password.matches(".*[!@#$%^&*].*")) {
            throw new IllegalArgumentException("Password should contain at least one special character");
        }
    }

    public static void validateAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (address.getStreet() == null || address.getStreet().isEmpty()) {
            throw new IllegalArgumentException("Street cannot be empty");
        }
        if (address.getCity() == null || address.getCity().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        if (address.getState() == null || address.getState().isEmpty()) {
            throw new IllegalArgumentException("State cannot be empty");
        }
        if (address.getPinCode() == null || address.getPinCode().isEmpty()) {
            throw new IllegalArgumentException("Zip code cannot be empty");
        }
        if (!address.getPinCode().matches("\\d{5}")) {
            throw new IllegalArgumentException("Invalid zip code format");
        }
    }
}