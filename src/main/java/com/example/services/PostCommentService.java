package com.example.services;

import com.example.repositories.PostCommentRepository;
import com.example.repositories.PostRepository;
import com.example.dto.PostCommentDto;
import com.example.models.User;
import com.example.models.PostComment;
import com.example.models.Post;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostCommentService {
    private final PostRepository postRepository;
    private final PostCommentRepository commentRepo;

    public PostCommentService(PostRepository postRepository, PostCommentRepository commentRepo) {
        this.postRepository = postRepository;
        this.commentRepo = commentRepo;
    }

    @Transactional
    public void saveComment(PostCommentDto postCommentDto, User commentAuthor) {
        PostComment postComment = new PostComment();
        Post postEntity = postRepository.findById(postCommentDto.getPostId());
        postComment.setCommentText(postCommentDto.getCommentText());
        postComment.setCommentAuthor(commentAuthor);
        postComment.setCommentedOn(postEntity);
        postComment = commentRepo.save(postComment);
        System.out.println("PostCommentService: " + postComment);
        postEntity.getComments().add(postComment);
    }
}
