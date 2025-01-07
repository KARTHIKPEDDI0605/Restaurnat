package com.RestaurantRegister.Restaurant.Services;

import com.RestaurantRegister.Restaurant.Exception.CustomException;
import com.RestaurantRegister.Restaurant.Models.dto.Request.CreateRestaurantRequest;
import com.RestaurantRegister.Restaurant.Models.dto.Request.UpdateRestaurantRequest;
import com.RestaurantRegister.Restaurant.Models.dto.Response.CreateRestaurantResponse;
import com.RestaurantRegister.Restaurant.Models.Entity.RestaurantEntity;
import com.RestaurantRegister.Restaurant.Models.dto.Response.StatusResponse;
import com.RestaurantRegister.Restaurant.Models.dto.Response.UpdateRestaurantResponse;
import com.RestaurantRegister.Restaurant.Repository.RestaurantRepository;
import com.RestaurantRegister.Restaurant.Utils.DeleteRestaurant;
import com.RestaurantRegister.Restaurant.configs.KafkaConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.logging.Logger;

import static com.RestaurantRegister.Restaurant.Constants.Constants.*;



@Service
public class RestaurantService {
    Logger logger = Logger.getLogger(RestaurantService.class.getName());
    private final RestaurantRepository restaurantRepository;
    private final KafkaConfiguration kafkaConfiguration;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, KafkaConfiguration kafkaConfiguration) {
        this.restaurantRepository = restaurantRepository;
        this.kafkaConfiguration = kafkaConfiguration;
    }

    public CreateRestaurantResponse createRestaurant(CreateRestaurantRequest createRestaurantRequest) {
        logger.info("Create Restaurant Request: " + createRestaurantRequest.getRestaurantName());
        // Check if restaurantId or userName already exists in the database
        boolean userNameExists = restaurantRepository.existsByUserName(createRestaurantRequest.getUserName());
        boolean restaurantIdExists = restaurantRepository.existsById(createRestaurantRequest.getRestaurantId());
        boolean emailExists = restaurantRepository.existsByEmail(createRestaurantRequest.getEmail());

        if (userNameExists) {
           throw new CustomException("Username already exists");
        }
        if(emailExists){
            throw new IllegalArgumentException("Email already exists");
        }

        // Create a new Restaurant entity from the request
        RestaurantEntity restaurant = RestaurantEntity.builder()
                .restaurantId(createRestaurantRequest.getRestaurantId())
                .restaurantName(createRestaurantRequest.getRestaurantName())
                .userName(createRestaurantRequest.getUserName())
                .password(createRestaurantRequest.getPassword())
                .phoneNumber(createRestaurantRequest.getPhoneNumber())
                .email(createRestaurantRequest.getEmail())
                .ownerName(createRestaurantRequest.getOwnerName())
                .ownerPhoneNumber(createRestaurantRequest.getOwnerPhoneNumber())
                .ownerEmail(createRestaurantRequest.getOwnerEmail())
                .ownerAddress(createRestaurantRequest.getOwnerAddress())
                .status(RESTAURANT_STATUS_PENDING)
                .build();

        // Save the restaurant entity to the database
        RestaurantEntity savedRestaurant = restaurantRepository.save(restaurant);
        KafkaConfiguration.publishRestaurantCreatedEvent(createRestaurantRequest);

        // Create and return the response
        CreateRestaurantResponse response = new CreateRestaurantResponse.Builder()
                .restaurantName(savedRestaurant.getRestaurantName())
                .userName(savedRestaurant.getUserName())
                .phoneNumber(savedRestaurant.getPhoneNumber())
                .email(savedRestaurant.getEmail())
                .ownerName(savedRestaurant.getOwnerName())
                .ownerPhoneNumber(savedRestaurant.getOwnerPhoneNumber())
                .ownerEmail(savedRestaurant.getOwnerEmail())
                .ownerAddress(savedRestaurant.getOwnerAddress())
                .status(RESTAURANT_STATUS_SUBMITTED)
                .build();

        return response;
    }

    public UpdateRestaurantResponse updateRestaurant(UpdateRestaurantRequest updateRestaurantRequest, String restaurantId) {
        // Check if the restaurant exists in the database
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if (restaurant == null) {
            throw new CustomException("Restaurant does not exist");
        }

        // Check if the username already exists in the database (excluding the current user's username)
        if (updateRestaurantRequest.getUserName() != null && !updateRestaurantRequest.getUserName().equals(restaurant.getUserName())) {
            boolean userNameExists = restaurantRepository.existsByUserName(updateRestaurantRequest.getUserName());
            if (userNameExists) {
                throw new CustomException("Username already exists");
            }
        }

        // Check if the email already exists in the database (excluding the current restaurant's email)
        if (updateRestaurantRequest.getEmail() != null && !updateRestaurantRequest.getEmail().equals(restaurant.getEmail())) {
            boolean emailExists = restaurantRepository.existsByEmail(updateRestaurantRequest.getEmail());
            if (emailExists) {
                throw new CustomException("Email already exists");
            }
        }

        // Update only the non-null or non-empty fields from the request
        if (updateRestaurantRequest.getRestaurantName() != null) {
            restaurant.setRestaurantName(updateRestaurantRequest.getRestaurantName());
        }
        if (updateRestaurantRequest.getPhoneNumber() != null) {
            restaurant.setPhoneNumber(updateRestaurantRequest.getPhoneNumber());
        }
        if (updateRestaurantRequest.getEmail() != null) {
            restaurant.setEmail(updateRestaurantRequest.getEmail());
        }
        if (updateRestaurantRequest.getOwnerAddress() != null) {
            restaurant.setOwnerAddress(updateRestaurantRequest.getOwnerAddress());
        }
        if (updateRestaurantRequest.getOwnerName() != null) {
            restaurant.setOwnerName(updateRestaurantRequest.getOwnerName());
        }
        if (updateRestaurantRequest.getOwnerPhoneNumber() != null) {
            restaurant.setOwnerPhoneNumber(updateRestaurantRequest.getOwnerPhoneNumber());
        }
        if (updateRestaurantRequest.getOwnerEmail() != null) {
            restaurant.setOwnerEmail(updateRestaurantRequest.getOwnerEmail());
        }

        // Save the updated restaurant entity
        restaurantRepository.save(restaurant);


        // Create and return the response object
        return new UpdateRestaurantResponse.Builder()
                .restaurantName(restaurant.getRestaurantName())
                .userName(restaurant.getUserName())
                .phoneNumber(restaurant.getPhoneNumber())
                .email(restaurant.getEmail())
                .ownerName(restaurant.getOwnerName())
                .ownerPhoneNumber(restaurant.getOwnerPhoneNumber())
                .ownerEmail(restaurant.getOwnerEmail())
                .ownerAddress(restaurant.getOwnerAddress())
                .build();
    }

    public  DeleteRestaurant deleteRestaurant(String restaurantId) {
        // Check if the restaurant exists in the database
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurant == null) {
            throw new CustomException("Restaurant does not exist");
        }

        // Fetch restaurant name
        String userName = restaurant.getUserName();  // Assuming you have a getUserName() method in Restaurant entity

        // Delete the restaurant
        restaurantRepository.deleteById(restaurantId);

        // Create and return the DeleteRestaurant response with the restaurant name
        DeleteRestaurant deleteResponse = new DeleteRestaurant.Builder()
                .restaurantName(userName)
                .build();

        return deleteResponse;
    }

    public StatusResponse getRestaurantStatus(String restaurantId) {
        // Check if the restaurant exists in the database
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if (restaurant == null) {
            throw new CustomException("Restaurant does not exist");
        }
        // Create and return the StatusResponse object
        return new StatusResponse.Builder()
                .restaurantName(restaurant.getRestaurantName())
                .status(restaurant.getStatus())
                .message(
                        restaurant.getStatus().equals(RESTAURANT_STATUS_PENDING) ? "Your license is pending" :
                                restaurant.getStatus().equals(RESTAURANT_STATUS_REJECTED) ? "Your license is rejected" :
                                        restaurant.getStatus().equals(RESTAURANT_STATUS_APPROVED) ? "Your license is approved" :
                                                ""
                )
                .build();
    }
}