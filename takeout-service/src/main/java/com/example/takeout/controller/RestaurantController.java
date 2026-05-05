package com.example.takeout.controller;

import com.example.takeout.dto.DishDetailDto;
import com.example.takeout.dto.RestaurantDto;
import com.example.takeout.service.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public ResponseEntity<Page<RestaurantDto>> listRestaurants(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String category) {

        Pageable pageable = PageRequest.of(page, size);
        Page<RestaurantDto> restaurantPage = restaurantService.searchRestaurants(keyword, category, pageable);
        return ResponseEntity.ok(restaurantPage);
    }

    @GetMapping("/dishes/{id}")
    public ResponseEntity<DishDetailDto> getDishDetail(@PathVariable("id") Long id) {
        DishDetailDto detail = restaurantService.getDishDetail(id);
        return ResponseEntity.ok(detail);
    }
}
