package com.example.teamapp.repositories;

import com.example.teamapp.models.Auth.UserEntity;
import com.example.teamapp.models.PostEntity;
import com.example.teamapp.models.VisibilityEnum;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepo extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findPostsByPostAuthorUsernameOrderByCreatedDateDesc(String postAuthor_username);
    PostEntity findById(UUID id);

    List<PostEntity> findPostsByPostAuthorUsernameAndPostVisibilityGreaterThanEqual(String postAuthor_username, VisibilityEnum postVisibility);
    List<PostEntity> findPostsByPostVisibilityGreaterThanEqual(VisibilityEnum postVisibility);

    List<PostEntity> findPostsByPostAuthorUsername(String postAuthor_username);
}
