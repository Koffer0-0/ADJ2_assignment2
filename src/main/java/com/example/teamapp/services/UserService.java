package com.example.teamapp.services;

import com.example.teamapp.dto.UserDto;
import com.example.teamapp.models.Auth.UserEntity;
import com.example.teamapp.models.VisibilityEnum;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.teamapp.repositories.UserRepo;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserService {

    private final UserRepo userRepo;
    final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(final UserDto userDto){
        UserEntity customerModel = addUser(userDto);
        userRepo.save(customerModel);
    }

    public boolean isUserExist(final UserDto user){
        UserEntity userFromDb = userRepo.findByUsername(user.getUsername());
        if(userFromDb != null)
            return passwordEncoder.matches(user.getPassword(), userFromDb.getPassword());
        return false;
    }

    public List<UserEntity> findUsers(final String username){
        return userRepo.findUsersByUsername(username);
    }

    public UserEntity findUserById(final UUID id) {
        return userRepo.findById(id);
    }

    public UserEntity findUserByUsername(final String username) {
        return userRepo.findByUsername(username);
    }

    private UserEntity addUser(final UserDto userDto){
        UserEntity user = new UserEntity();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }

    public boolean areFriends(String username, String principalUsername) {
        UserEntity user = findUserByUsername(username);
        UserEntity principalUser = findUserByUsername(principalUsername);
        return user.getFriends().contains(principalUser);
    }

    public boolean isPageOwner(final String username, final Principal principal) {
        boolean isPageOwner = false;
        if (principal != null) {
            isPageOwner = principal.getName().equals(username);
        }
        return isPageOwner;
    }

    public VisibilityEnum determineAccessLevel(final String username, final Principal principal) {
        boolean isPageOwner = isPageOwner(username, principal);
        // TODO: refactor maybe?
        VisibilityEnum accessLevel;
        if (isPageOwner) {
            accessLevel = VisibilityEnum.VISIBLE_TO_FRIENDS;
        }
        else if (principal == null) {
            accessLevel = VisibilityEnum.VISIBLE_TO_ALL;
        } else {
            accessLevel = areFriends(username, principal.getName()) ? VisibilityEnum.VISIBLE_TO_FRIENDS : VisibilityEnum.VISIBLE_TO_USERS;
        }
        return accessLevel;
    }

    @Transactional
    public void setPageVisibility(String username, VisibilityEnum pageVisibility) {
        UserEntity user = findUserByUsername(username);
        System.out.println("Changed page visibility of " + username + " to " + pageVisibility);
        user.setPageVisibility(pageVisibility);
    }
}