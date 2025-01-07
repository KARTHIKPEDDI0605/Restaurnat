package com.RestaurantRegister.Restaurant.Models.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UpdateRestaurantResponse {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("restaurantName")
    private String restaurantName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("ownerName")
    private String ownerName;

    @JsonProperty("ownerPhoneNumber")
    private String ownerPhoneNumber;

    @JsonProperty("ownerEmail")
    private String ownerEmail;

    @JsonProperty("ownerAddress")
    private String ownerAddress;

    // Private constructor to enforce the builder pattern
    private UpdateRestaurantResponse(Builder builder) {
        this.userName = builder.userName;
        this.restaurantName = builder.restaurantName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.ownerName = builder.ownerName;
        this.ownerPhoneNumber = builder.ownerPhoneNumber;
        this.ownerEmail = builder.ownerEmail;
        this.ownerAddress = builder.ownerAddress;
    }

    // Manual builder class
    public static class Builder {
        private String userName;
        private String restaurantName;
        private String phoneNumber;
        private String email;
        private String ownerName;
        private String ownerPhoneNumber;
        private String ownerEmail;
        private String ownerAddress;

        // Setter methods for each property
        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder restaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder ownerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Builder ownerPhoneNumber(String ownerPhoneNumber) {
            this.ownerPhoneNumber = ownerPhoneNumber;
            return this;
        }

        public Builder ownerEmail(String ownerEmail) {
            this.ownerEmail = ownerEmail;
            return this;
        }

        public Builder ownerAddress(String ownerAddress) {
            this.ownerAddress = ownerAddress;
            return this;
        }

        // Build method to return the final UpdateRestaurantResponse object
        public UpdateRestaurantResponse build() {
            return new UpdateRestaurantResponse(this);
        }
    }
}
