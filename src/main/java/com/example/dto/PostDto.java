package com.example.dto;

import com.example.models.VisibilityEnum;

public class PostDto {
    private String postTitle;
    private String postText;
    private VisibilityEnum postVisibility;
    private boolean commentsEnabled;

    public PostDto() {
    }

    public PostDto(String postTitle, String postText) {
        this.postTitle = postTitle;
        this.postText = postText;
        this.postVisibility = VisibilityEnum.VISIBLE_TO_ALL;
        this.commentsEnabled = true;
    }

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


    public boolean isCommentsEnabled() {
        return commentsEnabled;
    }

    public void setCommentsEnabled(boolean commentsEnabled) {
        this.commentsEnabled = commentsEnabled;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

//    public boolean getCommentsEnabled() {
//        return commentsEnabled;
//    }
//
//    public void setCommentsEnabled(boolean commentsEnabled) {
//        this.commentsEnabled = commentsEnabled;
//    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public VisibilityEnum getPostVisibility() {
        return postVisibility;
    }

    public void setPostVisibility(VisibilityEnum postVisibility) {
        this.postVisibility = postVisibility;
    }
}
