package com.RestaurantRegister.Restaurant.Exception;

public class MenuException {
   public void itemException(String message){
      throw new IllegalArgumentException(message);
   }

}
