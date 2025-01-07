package com.RestaurantRegister.Restaurant.Utils;

import java.util.HashMap;

public class Menu {
    HashMap<String, Double> menuItems;
    public void Menu(){
        menuItems = new HashMap<>();
    }
    public void addMenuItem(String itemName, Double price){
        menuItems.put(itemName, price);
    }
    public void removeMenuItem(String itemName){
        menuItems.remove(itemName);
    }
    public void updateMenuItem(String itemName, Double price){
        menuItems.put(itemName, price);
    }
}
