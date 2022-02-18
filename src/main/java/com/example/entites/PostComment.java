package com.example.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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
