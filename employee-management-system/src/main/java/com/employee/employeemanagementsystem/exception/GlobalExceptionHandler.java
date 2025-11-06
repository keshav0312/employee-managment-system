package com.employee.employeemanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                    HttpServletRequest request) {

        ApiError error = new ApiError(
                LocalDateTime.now(),                     // timestamp
                HttpStatus.NOT_FOUND.value(),            // status code
                HttpStatus.NOT_FOUND.name(),             // status text
                ex.getMessage(),                         // exception message
                request.getRequestURI()                  // request path
        );
//        ApiError error = new ApiError();
//        error.setMessage(ex.getMessage());
//        error.setTimestamp(LocalDateTime.now());
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setPath(request.getRequestURI());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
