package com.example.teamapp.services;

import com.example.teamapp.dto.PostDto;
import com.example.teamapp.models.Auth.UserEntity;
import com.example.teamapp.models.PostEntity;
import com.example.teamapp.models.VisibilityEnum;
import com.example.teamapp.repositories.PostRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PostService {

    private final PostRepo postRepo;
    private final UserService userService;

    public PostService(PostRepo postRepo, UserService userService) {
        this.postRepo = postRepo;
        this.userService = userService;
    }

    @Transactional
    public void savePost(final PostDto postDto, final String username) {
        UserEntity user = userService.findUserByUsername(username);

        PostEntity postEntity = new PostEntity();
        postEntity.setPostTitle(postDto.getPostTitle());
        postEntity.setPostText(postDto.getPostText());
        postEntity.setPostAuthor(user);
        postEntity.setCommentsEnabled(postDto.isCommentsEnabled());
        postEntity.setPostVisibility(postDto.getPostVisibility());
        postEntity = postRepo.save(postEntity);
        user.getPosts().add(postEntity);
    }

    /**
     * @return all posts by visibility
     */
    public List<PostEntity> findPosts(VisibilityEnum postVisibility) {
        return postRepo.findPostsByPostVisibilityGreaterThanEqual(postVisibility);
    }

    /**
     *
     * @param username of the user
     * @return all posts of the user
     */
    public  List<PostEntity> findAllPostsOf(String username) {
        return postRepo.findPostsByPostAuthorUsername(username);
    }

    public PostEntity findPost(UUID postId) {
        return postRepo.findById(postId);
    }

    /**
     *
     * @param username of the user whose posts we're trying to find
     * @param principal current user
     * @return collection of posts with visibility in mind
     */

    public Collection<PostEntity> findPosts(String username, Principal principal) {

        VisibilityEnum accessLevel = userService.determineAccessLevel(username, principal);
        System.out.println("Access level for current principal " + accessLevel);

        return postRepo.findPostsByPostAuthorUsernameAndPostVisibilityGreaterThanEqual(username, accessLevel);
    }

    @Transactional
    public void setCommentsEnabled(final UUID postId, boolean commentsEnabled, Principal principal) throws Exception {
        PostEntity post = findPost(postId);
        if (post == null) {
            throw new Exception("Post doesn't exist");
        }
        if (!post.getPostAuthor().equals(userService.findUserByUsername(principal.getName()))) {
            throw new Exception("Can't change comments settings on someone else's post");
        }
        post.setCommentsEnabled(commentsEnabled);
    }
}
