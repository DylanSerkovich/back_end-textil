package com.guianella.backend_textil.infraestructure.rest.advice;

import com.guianella.backend_textil.infraestructure.exception.GenericClientException;
import com.guianella.backend_textil.infraestructure.exception.ValidationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationException> handleValidationErrors(MethodArgumentNotValidException ex, HttpServletRequest httpServletRequest){
        ValidationException validationException = new ValidationException("Validation Error",HttpStatus.BAD_REQUEST, "La solicitud no es válida debido a errores de validación en uno o más campos.",httpServletRequest);
        validationException.setErrors(ex.getBindingResult());
        return new ResponseEntity<>(validationException,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GenericClientException.class)
    public ResponseEntity<ProblemDetail> handNotFoundException(GenericClientException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatus(ex.getStatus());
        problemDetail.setTitle(ex.getTitle());
        problemDetail.setDetail(ex.getUserMessage());
        problemDetail.setProperty("developerMessage",ex.getDeveloperMessage());
        return new ResponseEntity<>(problemDetail,ex.getStatus());
    }
}
