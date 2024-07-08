package com.hasher.userservice.exceptions;

import com.hasher.userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(
            ResourceNotFoundException exception) {
        String message = exception.getMessage();
        ApiResponse apiResponse = ApiResponse.builder()
                .msg(message)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
