package com.takeout.repository;

import com.takeout.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRestaurantId(Long restaurantId);
    List<Comment> findByOrderId(Long orderId);
}
