package com.example.takeout.dto;

import com.example.takeout.model.Restaurant;

public class RestaurantDto {

    private Long id;
    private String name;
    private String category;
    private String description;
    private String imageUrl;
    private int dishCount;

    public RestaurantDto() {
    }

    public RestaurantDto(Long id, String name, String category, String description, String imageUrl, int dishCount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
        this.dishCount = dishCount;
    }

    public static RestaurantDto from(Restaurant restaurant) {
        return new RestaurantDto(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getCategory(),
                restaurant.getDescription(),
                restaurant.getImageUrl(),
                restaurant.getDishes().size()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getDishCount() {
        return dishCount;
    }
}
