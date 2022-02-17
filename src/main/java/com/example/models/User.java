package com.example.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User extends Abstract {

    private String username;
    private String password;

    // TODO(Make friends)
    //  list all users in findUsers if username is not specified
    //  and add button to send friend request
    //  page to see incoming friend request
    //  accept from there
    @ManyToMany
    private Collection<User> friends = new ArrayList<>();

    @JsonManagedReference
    @OneToMany()
    private Collection<Post> posts = new ArrayList<>();

    private VisibilityEnum pageVisibility = VisibilityEnum.VISIBLE_TO_ALL;

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public Collection<User> getFriends() {
        return friends;
    }

    public VisibilityEnum getPageVisibility() {
        return pageVisibility;
    }

    public void setPageVisibility(VisibilityEnum pageVisibility) {
        this.pageVisibility = pageVisibility;
    }

}
