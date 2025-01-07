package com.RestaurantRegister.Restaurant.Services;

import com.RestaurantRegister.Restaurant.Models.dto.Request.MenuRequest;
import com.RestaurantRegister.Restaurant.Models.dto.Response.MenuResponse;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    public void deleteMenu(String menuId, String restaurantId) {
    }
    public  MenuResponse addMenu(MenuRequest addMenuRequest, String restaurantId) {
        return null;
    }
    public MenuResponse updateMenu(MenuRequest updateMenuRequest, String restaurantId) {
        return null;
    }

}
