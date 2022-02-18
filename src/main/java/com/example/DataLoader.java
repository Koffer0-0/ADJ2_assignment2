package com.example;

import com.example.dto.PostCommentDto;
import com.example.dto.PostDto;
import com.example.dto.UserDto;
import com.example.entites.User;
import com.example.entites.Post;
import com.example.entites.Visibility;
import com.example.services.PostCommentService;
import com.example.services.PostService;
import com.example.services.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {

    private final UserService userService;
    private final PostService postService;
    private final PostCommentService postCommentService;

    public DataLoader(UserService userService, PostService postService, PostCommentService postCommentService) {
        this.userService = userService;
        this.postService = postService;
        this.postCommentService = postCommentService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        // create users
        System.out.println(
                "user: Maksat, pass: 1111}\n" +
                "user: Timur, pass: 2222}\n" +
                "user: John, pass: 3333}\n");

        UserDto user1 = new UserDto("Maksat", "1111");
        UserDto user2 = new UserDto("Timur", "2222");
        UserDto user3 = new UserDto("John", "3333");

        boolean isUserExist = userService.isUserExist(user1);

        if (isUserExist) {
            System.out.println("SetupDataLoader: Setup already done");
            return;
        }

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);

        User user1Entity = userService.findUserByUsername(user1.getUsername());
        User user2Entity = userService.findUserByUsername(user2.getUsername());
        user1Entity.getFriends().add(user2Entity);
        user2Entity.getFriends().add(user1Entity);

        PostDto postVisibleToAll = new PostDto("Саламалаейкум!", "этот пост виден всем", false);
        PostDto postVisibleToUsers = new PostDto("Всем салам!", "этот пост видят только аутентифицированные", true, Visibility.VISIBLE_TO_USERS);
        PostDto postVisibleToFriends = new PostDto("Друзьям салам", "этот пост виден друзьям", true, Visibility.VISIBLE_TO_FRIENDS);

        postService.savePost(postVisibleToFriends, user1.getUsername());
        postService.savePost(postVisibleToUsers, user1.getUsername());

        postService.savePost(postVisibleToAll, user2.getUsername());
        Post post = postService.findAllPostsOf(user2.getUsername()).get(0);

        PostCommentDto postCommentDto = new PostCommentDto(post.getId(), "Хэй!");

        postCommentService.saveComment(postCommentDto, userService.findUserByUsername(user1.getUsername()));

        System.out.println("SetupDataLoader: completed setup\n");
    }

}
