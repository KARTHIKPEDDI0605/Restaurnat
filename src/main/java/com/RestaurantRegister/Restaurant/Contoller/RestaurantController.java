package com.RestaurantRegister.Restaurant.Contoller;

import com.RestaurantRegister.Restaurant.Contoller.Api.RestaurantApi;
import com.RestaurantRegister.Restaurant.Models.dto.Request.CreateRestaurantRequest;
import com.RestaurantRegister.Restaurant.Models.dto.Request.UpdateRestaurantRequest;
import com.RestaurantRegister.Restaurant.Models.dto.Response.CreateRestaurantResponse;
import com.RestaurantRegister.Restaurant.Models.dto.Response.StatusResponse;
import com.RestaurantRegister.Restaurant.Models.dto.Response.UpdateRestaurantResponse;
import com.RestaurantRegister.Restaurant.Services.RestaurantService;
import com.RestaurantRegister.Restaurant.Utils.*;
import com.RestaurantRegister.Restaurant.Validation.CreateRestaurantRequestValidation;
import com.RestaurantRegister.Restaurant.Validation.UpdateRestaurantRequestValidation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@Slf4j
@RestController
@RequiredArgsConstructor
public class RestaurantController implements RestaurantApi {
    Logger logger = Logger.getLogger(RestaurantController.class.getName());
    @Autowired
    private RestaurantService restaurantService;
    @Operation(summary = "Create a Restaurant", description = """
            Following are the validations-
            -Restaurant Name should not be Empty.
            -Restaurant document is required """)
    @PostMapping(value = "/createrestaurant", consumes = {"application/json"}, produces = {"application/json"})
    @Override
    public ResponseEntity<CreateRestaurantResponse> createRestaurant(@RequestBody CreateRestaurantRequest createRestaurantRequest) {
        logger.info(String.format("Create Restaurant Request: %s",createRestaurantRequest.getRestaurantId()));
        CreateRestaurantRequest createRestaurantRequest1 = CreateRestaurantRequestValidation.validate(createRestaurantRequest);
        CreateRestaurantResponse createRestaurantResponse = restaurantService.createRestaurant(createRestaurantRequest1);
        logger.info(String.format("Created Restaurant with the Response: %s", createRestaurantResponse.getRestaurantName()));
        return ResponseEntity.accepted().body(createRestaurantResponse);
    }

    @Override
    @PatchMapping(value = "/restaurants/{restaurantId}/update")
    public ResponseEntity<UpdateRestaurantResponse> updateRestaurant(@RequestBody UpdateRestaurantRequest updateRestaurantRequest, @PathVariable String restaurantId) {
        logger.info(String.format("Update Restaurant Request: %s",restaurantId));
        UpdateRestaurantRequest updatedRequest = UpdateRestaurantRequestValidation.validate(updateRestaurantRequest);
        UpdateRestaurantResponse res = restaurantService.updateRestaurant(updateRestaurantRequest, restaurantId);
        return ResponseEntity.accepted().body(res);
    }

    @Override
    @DeleteMapping(value = "/restaurants/{restaurantId}/delete")
    public ResponseEntity<DeleteRestaurant> deleteRestaurant( @PathVariable String restaurantId) {
        logger.info(String.format("Delete Restaurant Request: %s",restaurantId));
        DeleteRestaurant res = restaurantService.deleteRestaurant(restaurantId);
        return  ResponseEntity.accepted().body(res);
    }

    @Override
    @GetMapping(value = "/restaurants/{restaurantId}/status")
    public  ResponseEntity<StatusResponse> getRestaurantStatus(@PathVariable String restaurantId){
        logger.info(String.format("Get Restaurant Request: %s",restaurantId));
        StatusResponse res = restaurantService.getRestaurantStatus(restaurantId);
        return ResponseEntity.accepted().body(res);
    }
}
