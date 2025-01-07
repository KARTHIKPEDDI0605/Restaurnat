package com.RestaurantRegister.Restaurant.Utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteRestaurant {
    String restaurantName;

    public String getRestaurantName() {
        return restaurantName;
    }
    private DeleteRestaurant(Builder builder) {
        this.restaurantName = builder.restaurantName;
    }
    public  static class Builder {
        private String restaurantName;

        public Builder restaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }

        public DeleteRestaurant build() {
            return new DeleteRestaurant(this);
        }
    }
}
