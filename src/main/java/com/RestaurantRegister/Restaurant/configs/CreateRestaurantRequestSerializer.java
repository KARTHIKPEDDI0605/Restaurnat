package com.RestaurantRegister.Restaurant.configs;

import com.RestaurantRegister.Restaurant.Models.dto.Request.CreateRestaurantRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class CreateRestaurantRequestSerializer implements Serializer<CreateRestaurantRequest> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, CreateRestaurantRequest data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}