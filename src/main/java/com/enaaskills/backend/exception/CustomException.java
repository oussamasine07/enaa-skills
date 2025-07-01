package com.enaaskills.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInputValidationException (
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach(err -> {
                    String fieldName = ((FieldError) err).getField();
                    String fieldMessage = ((FieldError) err).getDefaultMessage();

                    errors.put(fieldName, fieldMessage);
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException (
            NotFoundException ex
    ) {
        Map<String, String> error = new HashMap<>();
        error.put("status", "error");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>( error, HttpStatus.NOT_FOUND );

    }
}




















