package com.RestaurantRegister.Restaurant.Contoller.Api;

import com.RestaurantRegister.Restaurant.Models.dto.Request.MenuRequest;
import com.RestaurantRegister.Restaurant.Models.dto.Response.MenuResponse;
import org.springframework.http.ResponseEntity;

public interface MenuApi {
    ResponseEntity<MenuResponse> addMenu(MenuRequest addMenuRequest, String restaurantId);
    ResponseEntity<MenuResponse> updateMenuRestaurant(MenuRequest updateMenuRequest, String restaurantId);
}
