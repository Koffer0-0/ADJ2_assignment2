package com.example.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PostComment extends Abstract {

    private String commentText;

    @JsonBackReference
    @ManyToOne
    private Post commentedOn;

    @JsonBackReference
    @ManyToOne
    private User commentAuthor;

    public PostComment() {
    }

    public Post getCommentedOn() {
        return commentedOn;
    }

    public void setCommentedOn(Post commentedOn) {
        this.commentedOn = commentedOn;
    }

    public User getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(User commentAuthor) {
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
