package com.example.takeout.cart;

public class CartItemDto {

    private Long dishId;
    private String name;
    private String description;
    private String imageUrl;
    private Integer unitPriceCents;
    private Integer quantity;
    private Integer totalPriceCents;

    public CartItemDto() {
    }

    public CartItemDto(Long dishId,
                       String name,
                       String description,
                       String imageUrl,
                       Integer unitPriceCents,
                       Integer quantity,
                       Integer totalPriceCents) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.unitPriceCents = unitPriceCents;
        this.quantity = quantity;
        this.totalPriceCents = totalPriceCents;
    }

    public Long getDishId() {
        return dishId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getUnitPriceCents() {
        return unitPriceCents;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getTotalPriceCents() {
        return totalPriceCents;
    }
}
