package com.azuryn.commerce.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.azuryn.commerce.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.stream.Collectors;
import com.azuryn.commerce.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex
    ) {
        var fieldErrors = ex.getBindingResult().getFieldErrors();
        var errors = fieldErrors.stream()
                .map(error -> Map.entry(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        var errorResponse = new ErrorResponse(
                400,
                "Validation failed",
                errors
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(
            ProductNotFoundException ex
    ) {
        ErrorResponse response = new ErrorResponse(
                404,
                ex.getMessage(),
                Map.of()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}