package com.RestaurantRegister.Restaurant.Models.dto.Request;

import com.RestaurantRegister.Restaurant.Utils.OrderDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class OrderRequest {
    @NotBlank
    @Schema(description = "Unique identifier of the order", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID orderId;

    @NotBlank
    @Schema(description = "Order details", example = "{burger: 1, fries: 2}")
    private OrderDetails orderDetails;

    @NotBlank
    @Schema(description = "Total amount for the order", example = "546.7")
    private Double totalAmount;

    @Schema(description = "Status of the order", example = "Pending")
    private String status;


}