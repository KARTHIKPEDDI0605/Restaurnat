package com.RestaurantRegister.Restaurant.Models.dto.Request;

import com.RestaurantRegister.Restaurant.Utils.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateRestaurantRequest {

   @JsonProperty("restaurantId")
   private String restaurantId;

   @JsonProperty("userName")
   private String userName;

   @JsonProperty("password")
   private String password;

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

   @JsonProperty("startTime")
   private String startTime;

   @JsonProperty("endTime")
   private String endTime;

   public String getRestaurantId() {
      return restaurantId;
   }

   public String getUserName() {
      return userName;
   }

   public String getPassword() {
      return password;
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