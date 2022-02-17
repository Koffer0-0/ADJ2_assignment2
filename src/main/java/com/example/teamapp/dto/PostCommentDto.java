package com.example.teamapp.dto;

import java.util.UUID;

public class PostCommentDto {
    private UUID postId;
    private String commentText;

    public PostCommentDto() {
    }

    public PostCommentDto(UUID postId, String commentText) {
        this.postId = postId;
        this.commentText = commentText;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
