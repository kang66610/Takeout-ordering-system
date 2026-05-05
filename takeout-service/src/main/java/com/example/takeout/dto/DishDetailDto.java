package com.example.takeout.dto;

import com.example.takeout.model.Dish;

public class DishDetailDto {

    private Long id;
    private String name;
    private String category;
    private String description;
    private String imageUrl;
    private Integer priceCents;
    private String restaurantName;

    public DishDetailDto() {
    }

    public DishDetailDto(Long id, String name, String category, String description, String imageUrl, Integer priceCents, String restaurantName) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
        this.priceCents = priceCents;
        this.restaurantName = restaurantName;
    }

    public static DishDetailDto from(Dish dish) {
        return new DishDetailDto(
                dish.getId(),
                dish.getName(),
                dish.getCategory(),
                dish.getDescription(),
                dish.getImageUrl(),
                dish.getPriceCents(),
                dish.getRestaurant() != null ? dish.getRestaurant().getName() : null
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

    public Integer getPriceCents() {
        return priceCents;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
}
