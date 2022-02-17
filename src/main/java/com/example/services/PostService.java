package com.example.services;

import com.example.repositories.PostRepository;
import com.example.dto.PostDto;
import com.example.models.User;
import com.example.models.Post;
import com.example.models.VisibilityEnum;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Transactional
    public void savePost(final PostDto postDto, final String username) {
        User user = userService.findUserByUsername(username);

        Post postEntity = new Post();
        postEntity.setPostTitle(postDto.getPostTitle());
        postEntity.setPostText(postDto.getPostText());
        postEntity.setPostAuthor(user);
        postEntity.setCommentsEnabled(postDto.isCommentsEnabled());
        postEntity.setPostVisibility(postDto.getPostVisibility());
        postEntity = postRepository.save(postEntity);
        user.getPosts().add(postEntity);
    }

    /**
     * @return all posts by visibility
     */
    public List<Post> findPosts(VisibilityEnum postVisibility) {
        return postRepository.findPostsByPostVisibilityGreaterThanEqual(postVisibility);
    }

    /**
     *
     * @param username of the user
     * @return all posts of the user
     */
    public  List<Post> findAllPostsOf(String username) {
        return postRepository.findPostsByPostAuthorUsername(username);
    }

    public Post findPost(UUID postId) {
        return postRepository.findById(postId);
    }

    /**
     *
     * @param username of the user whose posts we're trying to find
     * @param principal current user
     * @return collection of posts with visibility in mind
     */

    public Collection<Post> findPosts(String username, Principal principal) {

        VisibilityEnum accessLevel = userService.determineAccessLevel(username, principal);
        System.out.println("Access level for current principal " + accessLevel);

        return postRepository.findPostsByPostAuthorUsernameAndPostVisibilityGreaterThanEqual(username, accessLevel);
    }

    @Transactional
    public void setCommentsEnabled(final UUID postId, boolean commentsEnabled, Principal principal) throws Exception {
        Post post = findPost(postId);
        if (post == null) {
            throw new Exception("Post doesn't exist");
        }
        if (!post.getPostAuthor().equals(userService.findUserByUsername(principal.getName()))) {
            throw new Exception("Can't change comments settings on someone else's post");
        }
        post.setCommentsEnabled(commentsEnabled);
    }
}
