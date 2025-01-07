USE RestaurantDB;

CREATE TABLE IF NOT EXISTS restaurants (
                                           restaurant_id CHAR(36) PRIMARY KEY,  -- Updated to snake_case
                                           user_name VARCHAR(255) UNIQUE NOT NULL,  -- Updated to snake_case
                                           password VARCHAR(255) NOT NULL,
                                           restaurant_name VARCHAR(255) NOT NULL,  -- Updated to snake_case
                                           phone_number VARCHAR(20),  -- Updated to snake_case
                                           email VARCHAR(255) UNIQUE,
                                           owner_name VARCHAR(255),  -- Updated to snake_case
                                           owner_phone_number VARCHAR(20),  -- Updated to snake_case
                                           owner_email VARCHAR(255),  -- Updated to snake_case
                                           owner_address VARCHAR(255),  -- Updated to snake_case
                                           start_time VARCHAR(20),  -- Updated to snake_case
                                           end_time VARCHAR(20),  -- Updated to snake_case
                                           total_earnings_of_the_day DOUBLE,  -- Updated to snake_case
                                           total_earnings_of_the_month DOUBLE,  -- Updated to snake_case
                                           total_earnings_of_the_year DOUBLE,  -- Updated to snake_case
                                           created_at TIMESTAMP,  -- Updated to snake_case
                                           created_by VARCHAR(255),  -- Updated to snake_case
                                           last_modified_at TIMESTAMP,  -- Updated to snake_case
                                           last_modified_by VARCHAR(255),
                                           restaurant_status VARCHAR(36)  -- Updated to snake_case and added data type
);