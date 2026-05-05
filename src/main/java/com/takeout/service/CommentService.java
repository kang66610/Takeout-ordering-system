package com.takeout.service;

import com.takeout.entity.Comment;
import com.takeout.entity.Reply;
import com.takeout.repository.CommentRepository;
import com.takeout.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReplyRepository replyRepository;

    public Comment createComment(Comment comment) {
        comment.setCreateTime(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByRestaurantId(Long restaurantId) {
        return commentRepository.findByRestaurantId(restaurantId);
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Reply createReply(Reply reply) {
        reply.setCreateTime(LocalDateTime.now());
        return replyRepository.save(reply);
    }

    public List<Reply> getRepliesByCommentId(Long commentId) {
        return replyRepository.findByCommentId(commentId);
    }

    // Method to calculate average rating for a restaurant
    public double getAverageRating(Long restaurantId) {
        List<Comment> comments = commentRepository.findByRestaurantId(restaurantId);
        if (comments.isEmpty()) return 0.0;
        return comments.stream().mapToInt(Comment::getRating).average().orElse(0.0);
    }
}
