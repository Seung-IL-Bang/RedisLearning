package com.example.helloredis;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    // /login?name=Jay
    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name) {

        session.setAttribute(session.getId(), name);

        return "saved";
    }

    // myName => "Jay"
    @GetMapping("/myName")
    public String myName(HttpSession session) {

        String name = session.getAttribute(session.getId()).toString();

        return name;
    }

}
