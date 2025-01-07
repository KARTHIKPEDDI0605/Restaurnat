package com.RestaurantRegister.Restaurant.Contoller;

import com.RestaurantRegister.Restaurant.Contoller.Api.MenuApi;
import com.RestaurantRegister.Restaurant.Services.MenuService;
import com.RestaurantRegister.Restaurant.Models.dto.Request.MenuRequest;
import com.RestaurantRegister.Restaurant.Models.dto.Response.MenuResponse;
import com.RestaurantRegister.Restaurant.Validation.MenuValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/menu")
public class UpdateMenuController  implements MenuApi {
    private MenuService menuService;
    private MenuValidation menuValidation;

    @Override
    @PostMapping("/restaurant/{restaurantId}/add")
    public ResponseEntity<MenuResponse> addMenu(@RequestBody MenuRequest addMenuRequest, @PathVariable String restaurantId) {
        //log.info("Add Menu Request: for the restaurant {}, with the following Menu", addMenuRequest);
        menuValidation.validateMenu(addMenuRequest);
        MenuResponse addMenuResponse = menuService.addMenu(addMenuRequest,restaurantId);
        return ResponseEntity.ok(addMenuResponse);
    }

    @Override
    @PostMapping("/restauarant/{restaurantId}/update")
    public ResponseEntity<MenuResponse> updateMenuRestaurant(@RequestBody MenuRequest updateMenuRequest, @PathVariable String restaurantId) {
       // log.info("Update Menu Request: for the restaurant {}, with the following Menu", updateMenuRequest);
        menuValidation.validateMenu(updateMenuRequest);
        MenuResponse updateMenuResponse = menuService.updateMenu(updateMenuRequest,restaurantId);
        return ResponseEntity.ok(updateMenuResponse);
    }
}
