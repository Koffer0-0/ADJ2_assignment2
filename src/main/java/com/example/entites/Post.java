package com.example.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
public class Post extends Abstract {

    private String postTitle;
    private String postText;

    @ManyToOne
    @JsonBackReference
    private User postAuthor;

    @JsonManagedReference
    @OneToMany
    private Collection<PostComment> comments = new ArrayList<>();

    /**
     * Users can disable comments on their posts
     * Existing comments should be displayed, but new comments cannot be added
     */
    private boolean isCommentsEnabled = true;
    private VisibilityEnum postVisibility;

    @Override
    public String toString() {
        return "PostEntity{" +
                "postTitle='" + postTitle + '\'' +
                ", postText='" + postText + '\'' +
                ", postAuthor=" + postAuthor +
                ", comments=" + comments +
                ", isCommentsEnabled=" + isCommentsEnabled +
                ", postVisibility=" + postVisibility +
                '}';
    }

}