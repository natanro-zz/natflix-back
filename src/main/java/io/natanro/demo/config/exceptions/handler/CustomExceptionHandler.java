package io.natanro.demo.config.exceptions.handler;

import io.natanro.demo.config.exceptions.ApiException;
import io.natanro.demo.rest.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ApiException ex) {
        ErrorResponse error = ErrorResponse
            .builder()
            .title(ex.getTitle())
            .details(ex.getMessage())
            .status(HttpStatus.NOT_FOUND)
            .build();
        return ResponseEntity.status(ex.getHttpStatus()).body(error);
    }

}
