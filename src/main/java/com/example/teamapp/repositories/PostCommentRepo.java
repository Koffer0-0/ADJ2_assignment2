package com.example.teamapp.repositories;

import com.example.teamapp.models.PostCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostCommentRepo extends JpaRepository<PostCommentEntity, UUID> {
}
