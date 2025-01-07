package com.RestaurantRegister.Restaurant.Contoller.Api;

import com.RestaurantRegister.Restaurant.Models.dto.Request.CreateRestaurantRequest;
import com.RestaurantRegister.Restaurant.Models.dto.Request.UpdateRestaurantRequest;
import com.RestaurantRegister.Restaurant.Models.dto.Response.CreateRestaurantResponse;
import com.RestaurantRegister.Restaurant.Models.dto.Response.StatusResponse;
import com.RestaurantRegister.Restaurant.Models.dto.Response.UpdateRestaurantResponse;
import com.RestaurantRegister.Restaurant.Utils.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1")
public interface RestaurantApi {
   @Tag(name = "Restaurant", description = "restaurant api")
   @Operation(summary = "Create a Restaurant", description = """
           Following are the validations-
           -Restaurant Name should not be Empty.
           -Restaurant document is required. """)
   @ApiResponses(value={
           @ApiResponse(responseCode = "201", description = "Create Restaurant  created",
                   content = @Content(schema = @Schema(implementation = CreateRestaurantRequest.class))),
           @ApiResponse(responseCode = "400", description = "Error validating input parameters",
                   content = @Content(examples = @ExampleObject(
                           value = "{\"message\": [\"Input data  is not valid\"],\"statusCode\": 400}")))})
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CreateRestaurantResponse> createRestaurant(@RequestBody CreateRestaurantRequest createRestaurantRequest);


    @Tag(name = "Restaurant", description = "restaurant api")
    @Operation(summary = "Update Restaurant", description = """
           Following are the validations-
           -Restaurant Name should not be Empty.
           """)
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "updated the Restaurant",
                    content = @Content(schema = @Schema(implementation = UpdateRestaurantRequest.class))),
            @ApiResponse(responseCode = "400", description = "Error validating input parameters",
                    content = @Content(examples = @ExampleObject(
                            value = "{\"message\": [\"Input data  is not valid\"],\"statusCode\": 400}")))})
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UpdateRestaurantResponse> updateRestaurant(@RequestBody UpdateRestaurantRequest updateRestaurantRequest, String restaurantId);


    @Tag(name = "Restaurant", description = "restaurant api")
    @Operation(summary = "Delete Restaurant", description = """
           . Delete the Restaurant
           """)
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "delete Restaurant",
                    content = @Content(schema = @Schema(implementation = CreateRestaurantRequest.class))),
            @ApiResponse(responseCode = "404", description = "Error validating input parameters",
                    content = @Content(examples = @ExampleObject(
                            value = "{\"message\": [\"Restaurant Does no Exists\"],\"statusCode\": 404}")))})
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DeleteRestaurant> deleteRestaurant(String restaurantId);

    ResponseEntity<StatusResponse> getRestaurantStatus(String restaurantId);
}
