package com.guianella.backend_textil.infraestructure.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{
    private final String title;
    private final String developerMessage;
    private final String userMessage;
    private String errorCode;

    public NotFoundException(String title, String message, String userMessage){
        super(message);
        this.title = title;
        this.developerMessage = message;
        this.userMessage = userMessage;
    }

}
