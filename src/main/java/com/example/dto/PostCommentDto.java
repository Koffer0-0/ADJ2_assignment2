package com.example.dto;

import java.util.UUID;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCommentDto {

    private UUID postId;
    private String commentText;

}
