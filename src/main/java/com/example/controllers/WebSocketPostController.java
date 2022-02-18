package com.example.teamapp.controllers;


import com.example.teamapp.dto.PostDto;
import com.example.teamapp.models.PostEntity;
import com.example.teamapp.models.VisibilityEnum;
import com.example.teamapp.services.PostService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WebSocketPostController {

    private final PostService postService;

    public WebSocketPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public Iterable<PostEntity> getPosts(){
        return postService.findPosts(VisibilityEnum.VISIBLE_TO_ALL);
    }


    @SendTo("/blog/add")
    @MessageMapping("/addBlogPost")
    @PreAuthorize("hasRole('USERS')")
    public PostEntity addPost(PostDto postDto, Principal principal){
        try {
            return postService.savePostWebSocket(postDto, principal.getName());
        } catch (Exception e) {
            return new PostEntity();
        }
    }

}
