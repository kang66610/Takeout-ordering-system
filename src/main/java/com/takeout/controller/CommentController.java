package com.takeout.controller;

import com.takeout.entity.Comment;
import com.takeout.entity.Reply;
import com.takeout.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.createComment(comment);
        return ResponseEntity.ok(savedComment);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Comment>> getCommentsByRestaurant(@PathVariable Long restaurantId) {
        List<Comment> comments = commentService.getCommentsByRestaurantId(restaurantId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        Optional<Comment> comment = commentService.getCommentById(id);
        return comment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{commentId}/reply")
    public ResponseEntity<Reply> createReply(@PathVariable Long commentId, @RequestBody Reply reply) {
        reply.setCommentId(commentId);
        Reply savedReply = commentService.createReply(reply);
        return ResponseEntity.ok(savedReply);
    }

    @GetMapping("/{commentId}/replies")
    public ResponseEntity<List<Reply>> getReplies(@PathVariable Long commentId) {
        List<Reply> replies = commentService.getRepliesByCommentId(commentId);
        return ResponseEntity.ok(replies);
    }

    @GetMapping("/restaurant/{restaurantId}/rating")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long restaurantId) {
        double avgRating = commentService.getAverageRating(restaurantId);
        return ResponseEntity.ok(avgRating);
    }
}
