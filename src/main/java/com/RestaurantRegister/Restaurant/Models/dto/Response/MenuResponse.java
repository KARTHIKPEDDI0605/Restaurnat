package com.RestaurantRegister.Restaurant.Models.dto.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MenuResponse {
    @NotBlank
    @Schema(description = "Name of the item", example = "Burger", required = true)
    private String ItemName;

    @NotBlank
    @Schema(description = "Price of the item", example = "5.99", required = true)
    private Double price;

    @Schema(description = "Description of the item", example = "A delicious burger", required = true)
    private String description;

    @Schema(description = "availability of the item", example = "true", required = true)
    private Boolean available;
}
