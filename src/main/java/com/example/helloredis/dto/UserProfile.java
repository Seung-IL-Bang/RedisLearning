package com.example.helloredis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfile {

    @JsonProperty // 해당 필드를 JSON 형태로 반환할 수 있도록 해줌
    private String name;

    @JsonProperty
    private int age;

    public UserProfile(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
