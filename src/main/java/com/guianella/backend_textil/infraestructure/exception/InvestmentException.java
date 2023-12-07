package com.guianella.backend_textil.infraestructure.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvestmentException {
    private final HttpStatus status;
    private final String message;
    private final Instant timestamp = Instant.now();
    private final Map<String, String> errorMessages = new HashMap<>();
    private String code;

    public InvestmentException(HttpStatus status, String message, String code) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public InvestmentException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public void setErrors(BindingResult result) {
        for (FieldError error : result.getFieldErrors()) {
            String key = error.getField();
            String value = error.getDefaultMessage();
            this.errorMessages.put(key, value);
        }
    }
}
