package com.RestaurantRegister.Restaurant.Models.dto.Request;

import com.RestaurantRegister.Restaurant.Utils.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request body required to update a restaurant")
@Jacksonized
public class UpdateRestaurantRequest {
    @Schema(description = "Username of the restaurant owner", example = "restaurantOwner123")
    @JsonProperty
    private String userName;

    @NotBlank
    @Schema(description = "Name of the restaurant", example = "The Great Restaurant")
    @JsonProperty
    private String restaurantName;

    @Schema(description = "Address of the restaurant")
    @JsonProperty
    private Address address;

    @Schema(description = "Phone number of the restaurant", example = "123-456-7890")
    @JsonProperty
    private String phoneNumber;

    @JsonProperty
    @Schema(description = "Email of the restaurant", example = "contact@restaurant.com")
    private String email;

    @JsonProperty
    @Schema(description = "Name of the restaurant owner", example = "John Doe")
    private String ownerName;

    @JsonProperty
    @Schema(description = "Phone number of the restaurant owner", example = "098-765-4321")
    private String ownerPhoneNumber;

    @JsonProperty
    @Schema(description = "Email of the restaurant owner", example = "owner@restaurant.com")
    private String ownerEmail;

    @Schema(description = "Address of the restaurant owner")
    private String ownerAddress;

    @Schema(description = "Start time of the restaurant", example = "10:00 AM")
    private String startTime;

    @Schema(description = "End time of the restaurant", example = "10:00 PM")
    private String endTime;

    public String getUserName() {
        return userName;
    }


    public String getRestaurantName() {
        return restaurantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
