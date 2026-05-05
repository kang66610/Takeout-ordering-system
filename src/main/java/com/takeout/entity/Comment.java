package com.takeout.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    private Integer rating; // 1-5 stars

    @Column(name = "comment_text")
    private String commentText;

    @ElementCollection
    @CollectionTable(name = "comment_images", joinColumns = @JoinColumn(name = "comment_id"))
    @Column(name = "image_url")
    private List<String> images; // List of image URLs or paths

    @Column(name = "create_time")
    private LocalDateTime createTime;

    // Note: replies are fetched separately via service

    // Constructors, getters, setters
    public Comment() {}

    public Comment(Long id, Long orderId, Long userId, Long restaurantId, Integer rating, String commentText, List<String> images, LocalDateTime createTime) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.commentText = commentText;
        this.images = images;
        this.createTime = createTime;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getCommentText() { return commentText; }
    public void setCommentText(String commentText) { this.commentText = commentText; }

    public List<String> getImages() { return images; }
    public void setImages(List<String> images) { this.images = images; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
