package com.example.demo.services;

public class UserNotFound extends Throwable {
    public UserNotFound(String message) {
        super(message);
    }
}
