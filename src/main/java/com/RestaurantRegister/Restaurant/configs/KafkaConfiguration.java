package com.RestaurantRegister.Restaurant.configs;

import com.RestaurantRegister.Restaurant.Models.dto.Request.CreateRestaurantRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@Service
public class KafkaConfiguration {

    private static KafkaTemplate<String, String> kafkaTemplate = null;
    private static ObjectMapper objectMapper = null;

    public KafkaConfiguration(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    // Method to publish the restaurant creation event
    public static void publishRestaurantCreatedEvent(CreateRestaurantRequest createRestaurantRequest) {
        try {
            // Convert the CreateRestaurantRequest object to a JSON string
            String jsonMessage = objectMapper.writeValueAsString(createRestaurantRequest);

            // Send this message to the Kafka topic
            kafkaTemplate.send("restaurant-created-topic", jsonMessage);  // 'restaurant-created-topic' is the topic name
        } catch (JsonProcessingException e) {
            e.printStackTrace();  // Log the error or handle it appropriately
        }
    }

}
