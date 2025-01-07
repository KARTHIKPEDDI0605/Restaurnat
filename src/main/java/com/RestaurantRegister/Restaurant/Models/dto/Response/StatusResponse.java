package com.RestaurantRegister.Restaurant.Models.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusResponse {
   private String restaurantName;
    private String status;
    private String message;

    public StatusResponse(Builder builder) {
       this.message = builder.message;
       this.status = builder.status;
       this.restaurantName = builder.restaurantName;
    }
    public String getRestaurantName() {
        return restaurantName;
    }
    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public static  class  Builder{
        private String restaurantName;
        private String status;
        private String message;

        public Builder restaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public StatusResponse build() {
            return new StatusResponse(this);
        }
    }

}
