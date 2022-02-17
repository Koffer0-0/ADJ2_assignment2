package com.example.teamapp.services;

import com.example.teamapp.dto.PostCommentDto;
import com.example.teamapp.models.Auth.UserEntity;
import com.example.teamapp.models.PostCommentEntity;
import com.example.teamapp.repositories.PostCommentRepo;
import com.example.teamapp.models.PostEntity;
import com.example.teamapp.repositories.PostRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostCommentService {
    private final PostRepo postRepo;
    private final PostCommentRepo commentRepo;

    public PostCommentService(PostRepo postRepo, PostCommentRepo commentRepo) {
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

    @Transactional
    public void saveComment(PostCommentDto postCommentDto, UserEntity commentAuthor) {
        PostCommentEntity postComment = new PostCommentEntity();
        PostEntity postEntity = postRepo.findById(postCommentDto.getPostId());
        postComment.setCommentText(postCommentDto.getCommentText());
        postComment.setCommentAuthor(commentAuthor);
        postComment.setCommentedOn(postEntity);
        postComment = commentRepo.save(postComment);
        System.out.println("PostCommentService: " + postComment);
        postEntity.getComments().add(postComment);
    }
}
