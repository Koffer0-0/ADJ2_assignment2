package com.example.entites;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends Abstract {

    private String username;
    private String password;

    @ManyToMany
    private Collection<User> friends = new ArrayList<>();

    @JsonManagedReference
    @OneToMany()
    private Collection<Post> posts = new ArrayList<>();

    private VisibilityEnum pageVisibility = VisibilityEnum.VISIBLE_TO_ALL;

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
