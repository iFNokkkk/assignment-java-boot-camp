package com.work1.JavaBoot_WorkI.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String name) {
        super(name);
    }
}
