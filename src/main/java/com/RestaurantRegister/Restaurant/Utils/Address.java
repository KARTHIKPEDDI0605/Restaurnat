package com.RestaurantRegister.Restaurant.Utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    private String city;
    private String pinCode;
    private String state;
    private String District;
    private String country;
    private String houseNumber;

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return District;
    }

    public String getCountry() {
        return country;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
}