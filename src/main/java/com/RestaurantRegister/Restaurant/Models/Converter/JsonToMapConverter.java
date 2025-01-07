//package com.RestaurantRegister.Restaurant.Models.Converter;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.persistence.AttributeConverter;
//import jakarta.persistence.Converter;
//import org.apache.commons.collections4.MapUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.Map;
//
//@Converter
//public class JsonToMapConverter implements AttributeConverter<Map<String, String>, String> {
//
//    private static final ObjectMapper objectMapper = new ObjectMapper();
//    private static final Logger logger = LoggerFactory.getLogger(JsonToMapConverter.class);
//
//    /**
//     * It is used to convert input data to the database columns
//     *
//     * @param data the entity attribute value to be converted
//     * @return String of database column needs to be returned
//     */
//    @Override
//    public String convertToDatabaseColumn(Map<String, String> data) {
//        if (MapUtils.isEmpty(data)) {
//            return null;
//        }
//        try {
//            return objectMapper.writeValueAsString(data);
//        } catch (JsonProcessingException ex) {
//            logger.error("Couldn't convert data-list to JSON String.", ex);
//            return null;
//        }
//    }
//
//    /**
//     * It is used to convert database column to the entity
//     *
//     * @param jsonData the data from the database column to be
//     *                 converted
//     * @return Map of entities needs to be returned
//     */
//    @Override
//    public Map<String, String> convertToEntityAttribute(String jsonData) {
//        if (StringUtils.isBlank(jsonData)) {
//            return Collections.emptyMap();
//        }
//
//        try {
//            return objectMapper.readValue(jsonData, new TypeReference<>() {
//            });
//        } catch (IOException ex) {
//            logger.error("Couldn't convert JSON String to data-map.", ex);
//            return Collections.emptyMap();
//        }
//    }
//}
//
