package com.example.urlShorty.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {

    private static final String GLOBAL_ID_KEY = "global:id";

    private final StringRedisTemplate redisTemplate;
    private final KeyGenerator keyGenerator;

    public UrlShortenerService(StringRedisTemplate redisTemplate, KeyGenerator keyGenerator) {
        this.redisTemplate = redisTemplate;
        this.keyGenerator = keyGenerator;
    }

    public String shortenUrl(String longUrl) {
        Long id = redisTemplate.opsForValue().increment(GLOBAL_ID_KEY);

        String shortKey = keyGenerator.encode(id);

        redisTemplate.opsForValue().set(shortKey, longUrl);

        return shortKey;
    }

    public String getOriginalUrl(String shortKey){
        return redisTemplate.opsForValue().get(shortKey);
    }

}
