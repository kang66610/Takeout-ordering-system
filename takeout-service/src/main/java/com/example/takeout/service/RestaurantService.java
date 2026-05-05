package com.example.takeout.service;

import com.example.takeout.dto.DishDetailDto;
import com.example.takeout.dto.RestaurantDto;
import com.example.takeout.model.Dish;
import com.example.takeout.model.Restaurant;
import com.example.takeout.repository.DishRepository;
import com.example.takeout.repository.RestaurantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, DishRepository dishRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

    @Transactional(readOnly = true)
    public Page<RestaurantDto> searchRestaurants(String keyword, String category, Pageable pageable) {
        Page<Restaurant> restaurants = restaurantRepository.search(keyword, category, pageable);
        return restaurants.map(RestaurantDto::from);
    }

    @Transactional(readOnly = true)
    public DishDetailDto getDishDetail(Long dishId) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new NoSuchElementException("Dish not found: " + dishId));
        return DishDetailDto.from(dish);
    }
}
