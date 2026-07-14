package com.mehul.portfoliomanager.controller;

import com.mehul.portfoliomanager.dto.ErrorResponse;
import com.mehul.portfoliomanager.exception.PortfolioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PortfolioNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePortfolioNotFound(
            PortfolioNotFoundException ex) {

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}