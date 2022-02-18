package com.example.services;

import com.example.dto.UserDto;
import com.example.entites.User;
import com.example.entites.Visibility;
import com.example.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service("userService")
public class UserService {

    final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void saveUser(final UserDto userDto) {
        User customerModel = addUser(userDto);
        userRepository.save(customerModel);
    }

    public boolean isUserExist(final UserDto user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null)
            return passwordEncoder.matches(user.getPassword(), userFromDb.getPassword());
        return false;
    }

    public List<User> findUsers(final String username) {
        return userRepository.findUsersByUsername(username);
    }

    public User findUserById(final UUID id) {
        return userRepository.findById(id);
    }

    public User findUserByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    private User addUser(final UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }

    public boolean areFriends(String username, String principalUsername) {
        User user = findUserByUsername(username);
        User principalUser = findUserByUsername(principalUsername);
        return user.getFriends().contains(principalUser);
    }

    public boolean isPageOwner(final String username, final Principal principal) {
        boolean isPageOwner = false;
        if (principal != null) {
            isPageOwner = principal.getName().equals(username);
        }
        return isPageOwner;
    }

    public Visibility determineAccessLevel(final String username, final Principal principal) {
        boolean isPageOwner = isPageOwner(username, principal);
        Visibility accessLevel;
        if (isPageOwner) {
            accessLevel = Visibility.VISIBLE_TO_FRIENDS;
        } else if (principal == null) {
            accessLevel = Visibility.VISIBLE_TO_ALL;
        } else {
            accessLevel = areFriends(username, principal.getName()) ? Visibility.VISIBLE_TO_FRIENDS : Visibility.VISIBLE_TO_USERS;
        }
        return accessLevel;
    }

    @Transactional
    public void setPageVisibility(String username, Visibility pageVisibility) {
        User user = findUserByUsername(username);
        System.out.println("Changed page visibility of " + username + " to " + pageVisibility);
        user.setPageVisibility(pageVisibility);
    }

}