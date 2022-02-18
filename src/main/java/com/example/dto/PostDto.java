package com.example.dto;

import com.example.entites.Visibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private String postTitle;
    private String postText;
    private Visibility postVisibility;
    private boolean commentsEnabled;

    public PostDto(String postTitle, String postText, boolean isCommentsEnabled) {
        this.postTitle = postTitle;
        this.postText = postText;
        this.postVisibility = Visibility.VISIBLE_TO_ALL;
        this.commentsEnabled = isCommentsEnabled;
    }

    public PostDto(String postTitle, String postText, boolean isCommentsEnabled, Visibility postVisibility) {
        this.postTitle = postTitle;
        this.postText = postText;
        this.postVisibility = postVisibility;
        this.commentsEnabled = isCommentsEnabled;
    }

    public PostDto(String s) {

    }
}
