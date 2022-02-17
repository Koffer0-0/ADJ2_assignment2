package com.example.teamapp.models;

import com.example.teamapp.models.Auth.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PostCommentEntity extends AbstractEntity {

    private String commentText;

    @JsonBackReference
    @ManyToOne
    private PostEntity commentedOn;

    @JsonBackReference
    @ManyToOne
    private UserEntity commentAuthor;

    public PostCommentEntity() {
    }

    public PostEntity getCommentedOn() {
        return commentedOn;
    }

    public void setCommentedOn(PostEntity commentedOn) {
        this.commentedOn = commentedOn;
    }

    public UserEntity getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(UserEntity commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return "PostCommentEntity{" +
                "commentText='" + commentText + '\'' +
                ", commentAuthor=" + commentAuthor.getUsername() +
                '}';
    }
}
