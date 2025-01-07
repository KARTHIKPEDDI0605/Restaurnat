package com.RestaurantRegister.Restaurant.Validation;

import com.RestaurantRegister.Restaurant.Exception.CustomException;
import com.RestaurantRegister.Restaurant.Models.dto.Request.UpdateRestaurantRequest;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;


@Slf4j
@NoArgsConstructor
public class UpdateRestaurantRequestValidation {
    static Logger logger = Logger.getLogger(UpdateRestaurantRequestValidation.class.getName());
    public static UpdateRestaurantRequest validate(UpdateRestaurantRequest updateRestaurantRequest) {
        logger.info("Validating update restaurant request");
        // Validate non-null and non-empty fields
        if (updateRestaurantRequest.getRestaurantName() != null && updateRestaurantRequest.getRestaurantName().isEmpty()) {
            throw new CustomException("Restaurant name cannot be empty");
        }

        if (updateRestaurantRequest.getUserName() != null && updateRestaurantRequest.getUserName().isEmpty()) {
            throw new CustomException("User name cannot be empty");
        }

        if (updateRestaurantRequest.getPhoneNumber() != null && updateRestaurantRequest.getPhoneNumber().isEmpty()) {
            throw new CustomException("Phone number cannot be empty");
        }

        if (updateRestaurantRequest.getEmail() != null && updateRestaurantRequest.getEmail().isEmpty()) {
            throw new CustomException("Email cannot be empty");
        }

        if (updateRestaurantRequest.getOwnerName() != null && updateRestaurantRequest.getOwnerName().isEmpty()) {
            throw new CustomException("Owner name cannot be empty");
        }

        // Validate optional fields only if they are provided and are empty
        if (updateRestaurantRequest.getOwnerPhoneNumber() != null && updateRestaurantRequest.getOwnerPhoneNumber().isEmpty()) {
            throw new CustomException("Owner phone number cannot be empty");
        }

        if (updateRestaurantRequest.getOwnerEmail() != null && updateRestaurantRequest.getOwnerEmail().isEmpty()) {
            throw new CustomException("Owner email cannot be empty");
        }

        if (updateRestaurantRequest.getOwnerAddress() != null && updateRestaurantRequest.getOwnerAddress().isEmpty()) {
            throw new CustomException("Owner address cannot be empty");
        }

        if (updateRestaurantRequest.getStartTime() != null && updateRestaurantRequest.getStartTime().isEmpty()) {
            throw new CustomException("Start time cannot be empty");
        }

        // Validate phone number format
        if (updateRestaurantRequest.getPhoneNumber() != null && !updateRestaurantRequest.getPhoneNumber().isEmpty()) {
            validatePhoneNumber(updateRestaurantRequest.getPhoneNumber());
        }

        // Validate email format
        if (updateRestaurantRequest.getEmail() != null && !updateRestaurantRequest.getEmail().isEmpty()) {
            validateEmail(updateRestaurantRequest.getEmail());
        }

        // Validate owner phone number format (if present)
        if (updateRestaurantRequest.getOwnerPhoneNumber() != null && !updateRestaurantRequest.getOwnerPhoneNumber().isEmpty()) {
            validatePhoneNumber(updateRestaurantRequest.getOwnerPhoneNumber());
        }

        // Validate owner email format (if present)
        if (updateRestaurantRequest.getOwnerEmail() != null && !updateRestaurantRequest.getOwnerEmail().isEmpty()) {
            validateEmail(updateRestaurantRequest.getOwnerEmail());
        }
        logger.info("Update restaurant request is valid");
        return updateRestaurantRequest;
    }

    // Phone number validation logic
    public static void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new CustomException("Invalid phone number format");
        }
    }

    // Email validation logic
    public static void validateEmail(String email) {
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new CustomException("Invalid email format");
        }
    }
}
