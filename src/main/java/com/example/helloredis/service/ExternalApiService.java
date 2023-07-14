package com.example.helloredis.service;

import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {


    public String getUserName(String userId) throws InterruptedException {

        Thread.sleep(500); // 실제로는 외부 서비스나 DB 호출

        if (userId.equals("A")) {
            return "Adam";
        }
        if (userId.equals("B")) {
            return "Bob";
        }
        return "";
    }

    public int getUserAge(String userId) throws InterruptedException {

        Thread.sleep(500); // 실제로는 외부 서비스나 DB 호출

        System.out.println("Getting user age from other service ...");

        if (userId.equals("A")) {
            return 28;
        }
        if (userId.equals("B")) {
            return 32;
        }

        return 0;
    }
}
