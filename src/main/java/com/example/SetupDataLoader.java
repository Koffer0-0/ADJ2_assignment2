package com.example;

import com.example.dto.PostCommentDto;
import com.example.dto.PostDto;
import com.example.dto.UserDto;
import com.example.models.User;
import com.example.models.Post;
import com.example.models.VisibilityEnum;
import com.example.services.PostCommentService;
import com.example.services.PostService;
import com.example.services.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ApplicationReadyEvent> {


    private final UserService userService;
    private final PostService postService;
    private final PostCommentService postCommentService;

    public SetupDataLoader(UserService userService, PostService postService, PostCommentService postCommentService) {
        this.userService = userService;
        this.postService = postService;
        this.postCommentService = postCommentService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        // create users
        System.out.println("Hello!\n" +
                "{username: user1, password: 1234}\n" +
                "{username: user2, password: 1234}\n" +
                "They are friends c:");
        UserDto user1 = new UserDto("user1", "1234");
        boolean isUserExist = userService.isUserExist(user1);
        if (isUserExist) {
            System.out.println("SetupDataLoader: Setup already done");
            return;
        }
        UserDto user2 = new UserDto("user2", "1234");
        userService.saveUser(user1);
        userService.saveUser(user2);

        User user1Entity = userService.findUserByUsername(user1.getUsername());
        User user2Entity = userService.findUserByUsername(user2.getUsername());
        user1Entity.getFriends().add(user2Entity);
        user2Entity.getFriends().add(user1Entity);

        PostDto postVisibleToAll = new PostDto("Hello, world!", "all users can see this post", false);
        PostDto postVisibleToUsers = new PostDto("Hello, users!", "only authenticated users can see this post", true, VisibilityEnum.VISIBLE_TO_USERS);
        PostDto postVisibleToFriends = new PostDto("Hello, friends!", "only friends can see this post", true, VisibilityEnum.VISIBLE_TO_FRIENDS);
        postService.savePost(postVisibleToAll, user2.getUsername());
        postService.savePost(postVisibleToFriends, user1.getUsername());
        postService.savePost(postVisibleToUsers, user1.getUsername());

        Post post = postService.findAllPostsOf(user2.getUsername()).get(0);
        PostCommentDto postCommentDto = new PostCommentDto(post.getId(), "Hey!!");

        postCommentService.saveComment(postCommentDto, userService.findUserByUsername(user1.getUsername()));

        System.out.println("SetupDataLoader: completed setup\n");
    }
}
