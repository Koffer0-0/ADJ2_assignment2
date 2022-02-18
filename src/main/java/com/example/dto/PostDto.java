package com.example.dto;

import com.example.models.VisibilityEnum;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private String postTitle;
    private String postText;
    private VisibilityEnum postVisibility;
    private boolean commentsEnabled;

    public PostDto(String postTitle, String postText, boolean isCommentsEnabled) {
        this.postTitle = postTitle;
        this.postText = postText;
        this.postVisibility = VisibilityEnum.VISIBLE_TO_ALL;
        this.commentsEnabled = isCommentsEnabled;
    }

    public PostDto(String postTitle, String postText, boolean isCommentsEnabled, VisibilityEnum postVisibility) {
        this.postTitle = postTitle;
        this.postText = postText;
        this.postVisibility = postVisibility;
        this.commentsEnabled = isCommentsEnabled;
    }

}
