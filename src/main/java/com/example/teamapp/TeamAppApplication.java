package com.example.teamapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class TeamAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamAppApplication.class, args);
    }

}
