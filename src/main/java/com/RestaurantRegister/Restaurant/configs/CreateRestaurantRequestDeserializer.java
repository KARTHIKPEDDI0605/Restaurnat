package com.RestaurantRegister.Restaurant.configs;

import com.RestaurantRegister.Restaurant.Models.dto.Request.CreateRestaurantRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class CreateRestaurantRequestDeserializer implements Deserializer<CreateRestaurantRequest> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public CreateRestaurantRequest deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, CreateRestaurantRequest.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}