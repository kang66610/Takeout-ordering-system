package com.example.takeout.repository;

import com.example.takeout.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("select distinct r " +
           "from Restaurant r left join r.dishes d " +
           "where (:keyword is null or :keyword = '' " +
           "    or lower(r.name) like lower(concat('%', :keyword, '%')) " +
           "    or lower(r.category) like lower(concat('%', :keyword, '%')) " +
           "    or lower(d.name) like lower(concat('%', :keyword, '%')) " +
           "    or lower(d.description) like lower(concat('%', :keyword, '%')) ) " +
           "and (:category is null or :category = '' or lower(r.category) = lower(:category))")
    Page<Restaurant> search(@Param("keyword") String keyword,
                            @Param("category") String category,
                            Pageable pageable);
}
