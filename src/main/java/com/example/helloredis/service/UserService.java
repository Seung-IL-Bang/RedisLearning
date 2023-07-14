package com.example.helloredis.service;

import com.example.helloredis.dto.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    ExternalApiService externalApiService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public UserProfile getUserProfile(String userId) throws InterruptedException {

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String userName = null;
        int userAge = 0;

        // Caching
        String cachedname = ops.get("nameKey: " + userId);

        if (cachedname != null) {
            userName = cachedname;
        } else {
            // Cache miss 로 인한 DB 로부터 원본 데이터 가져오기 (Thread.sleep)
            userName = externalApiService.getUserName(userId);
            ops.set("nameKey: " + userId, userName, 5, TimeUnit.SECONDS);
        }

        userAge = externalApiService.getUserAge(userId);

        return new UserProfile(userName, userAge);
    }
}
