package com.example.repositories;

import com.example.models.Post;
import com.example.models.VisibilityEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByPostAuthorUsernameOrderByCreatedDateDesc(String postAuthor_username);
    Post findById(UUID id);

    List<Post> findPostsByPostAuthorUsernameAndPostVisibilityGreaterThanEqual(String postAuthor_username, VisibilityEnum postVisibility);
    List<Post> findPostsByPostVisibilityGreaterThanEqual(VisibilityEnum postVisibility);

    List<Post> findPostsByPostAuthorUsername(String postAuthor_username);
}
