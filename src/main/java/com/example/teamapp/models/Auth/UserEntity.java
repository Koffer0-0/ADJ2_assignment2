package com.example.teamapp.models.Auth;


import com.example.teamapp.models.AbstractEntity;
import com.example.teamapp.models.PostEntity;
import com.example.teamapp.models.VisibilityEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {

    private String username;
    private String password;

    // TODO(Make friends)
    //  list all users in findUsers if username is not specified
    //  and add button to send friend request
    //  page to see incoming friend request
    //  accept from there
    @ManyToMany
    private Collection<UserEntity> friends = new ArrayList<>();

    @JsonManagedReference
    @OneToMany()
    private Collection<PostEntity> posts = new ArrayList<>();

    private VisibilityEnum pageVisibility = VisibilityEnum.VISIBLE_TO_ALL;

    public UserEntity(){

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

    public Collection<PostEntity> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity user = (UserEntity) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public Collection<UserEntity> getFriends() {
        return friends;
    }

    public VisibilityEnum getPageVisibility() {
        return pageVisibility;
    }

    public void setPageVisibility(VisibilityEnum pageVisibility) {
        this.pageVisibility = pageVisibility;
    }
}
