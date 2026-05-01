package com.takeout.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "replies")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "reply_text")
    private String replyText;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    // Constructors, getters, setters
    public Reply() {}

    public Reply(Long id, Long commentId, Long merchantId, String replyText, LocalDateTime createTime) {
        this.id = id;
        this.commentId = commentId;
        this.merchantId = merchantId;
        this.replyText = replyText;
        this.createTime = createTime;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCommentId() { return commentId; }
    public void setCommentId(Long commentId) { this.commentId = commentId; }

    public Long getMerchantId() { return merchantId; }
    public void setMerchantId(Long merchantId) { this.merchantId = merchantId; }

    public String getReplyText() { return replyText; }
    public void setReplyText(String replyText) { this.replyText = replyText; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
