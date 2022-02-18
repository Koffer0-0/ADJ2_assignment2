package com.example.controllers;

import com.example.dto.PostDto;
import com.example.entites.Post;
import com.example.entites.Visibility;
import com.example.services.PostService;
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
    public Iterable<Post> getPosts() {
        return postService.findPosts(Visibility.VISIBLE_TO_ALL);
    }

    @SendTo("/blog/add")
    @MessageMapping("/addBlogPost")
    @PreAuthorize("hasRole('USERS')")
    public Post addPost(PostDto postDto, Principal principal) {
        try {
            return postService.savePostWebSocket(postDto, principal.getName());
        } catch (Exception e) {
            return new Post();
        }
    }

}
