package com.abhinav.abhinav_backend_starter.Exceptions;

import com.abhinav.abhinav_backend_starter.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(RequestFailedException.class)
    private ResponseEntity<ExceptionDto> handleRequestFailedException() {
        return new ResponseEntity(
                new ExceptionDto(HttpStatus.BAD_REQUEST, "Request Failed Exception"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<String> handleNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity(
                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
