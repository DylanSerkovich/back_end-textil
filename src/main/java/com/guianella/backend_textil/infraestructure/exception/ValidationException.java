package com.guianella.backend_textil.infraestructure.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidationException {
    private final String title;
    private final int statusCode;
    private String errorCode;
    private final String details;
    private final String instance;
    private List<FieldErrors> invalid_fields;

    public ValidationException(String title, HttpStatus status, String details, String errorCode, HttpServletRequest httpServlet) {
        super();
        this.title = title;
        this.statusCode= status.value();
        this.details = details;
        this.instance=httpServlet.getRequestURI();
        this.errorCode = errorCode;
    }

    public ValidationException(String title,HttpStatus status, String details, HttpServletRequest httpServlet) {
        super();
        this.statusCode= status.value();
        this.title = title;
        this.instance=httpServlet.getRequestURI();
        this.details = details;
    }

    public void setErrors(BindingResult result) {
        this.invalid_fields = result.getFieldErrors()
                .stream().map(error ->
                        new FieldErrors(error.getField(),error.getDefaultMessage())
                )
                .collect(Collectors.toList());
    }
}
