package com.abhinav.abhinav_backend_starter.Exceptions;

import com.abhinav.abhinav_backend_starter.Dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(RequestFailedException.class)
    private ResponseEntity<ExceptionDto> handleRequestFailedException(RequestFailedException requestFailedException) {
        return new ResponseEntity(
                new ExceptionDto(HttpStatus.BAD_REQUEST, requestFailedException.getMessage()),
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
