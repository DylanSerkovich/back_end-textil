package com.guianella.backend_textil.infraestructure.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericClientException extends RuntimeException{
    private final String title;
    private final HttpStatus status;
    private final String developerMessage;
    private final String userMessage;
    private String errorCode;

    public GenericClientException(HttpStatus status, String title, String message, String userMessage){
        super(message);
        this.status = status;
        this.title = title;
        this.developerMessage = message;
        this.userMessage = userMessage;
    }

}
