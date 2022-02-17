package com.example.teamapp.repositories;

import com.example.teamapp.models.Auth.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    List<UserEntity> findUsersByUsername(String username);
    UserEntity findById(UUID id);
}
