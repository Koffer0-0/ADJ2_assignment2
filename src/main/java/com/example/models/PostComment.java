package com.example.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class PostComment extends Abstract {

    private String commentText;

    @JsonBackReference
    @ManyToOne
    private Post commentedOn;

    @JsonBackReference
    @ManyToOne
    private User commentAuthor;

    @Override
    public String toString() {
        return "PostCommentEntity{" +
                "commentText='" + commentText + '\'' +
                ", commentAuthor=" + commentAuthor.getUsername() +
                '}';
    }

}
