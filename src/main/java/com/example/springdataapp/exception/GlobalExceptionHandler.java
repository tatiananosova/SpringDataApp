package com.example.springdataapp.exception;

import com.example.springdataapp.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ErrorResponseDto> handleEmptyResource(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDto(ex.getMessage()));
    }
}
