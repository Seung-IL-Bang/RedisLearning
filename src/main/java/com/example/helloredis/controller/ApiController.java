package com.example.helloredis.controller;

import com.example.helloredis.dto.UserProfile;
import com.example.helloredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}/profile")
    public UserProfile getUserProfile(@PathVariable("userId") String userId) throws InterruptedException {

        return userService.getUserProfile(userId);
    }
}
