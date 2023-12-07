package com.guianella.backend_textil.infraestructure.rest.advice;

import com.guianella.backend_textil.infraestructure.exception.InvestmentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InvestmentException> handleValidationErrors(MethodArgumentNotValidException ex){
        InvestmentException investmentException = new InvestmentException(HttpStatus.BAD_REQUEST, "los valores ingresados son incorrectos");
        investmentException.setErrors(ex.getBindingResult());
        return new ResponseEntity<>(investmentException,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
