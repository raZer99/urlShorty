package com.example.urlShorty.service;

import org.springframework.stereotype.Component;

@Component
public class KeyGenerator {

    private static final String BASE62 =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String encode(long value){
        StringBuilder sb = new StringBuilder();

        while(value>0){
            int index = (int) (value%BASE62.length());
            sb.append(BASE62.charAt(index));
            value = value/BASE62.length();
        }

        return sb.reverse().toString();
    }
}

