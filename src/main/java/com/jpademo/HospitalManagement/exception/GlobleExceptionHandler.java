package com.jpademo.HospitalManagement.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobleExceptionHandler
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){

        ErrorResponse errorResponse= ErrorResponse.builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .path(request.getRequestURI())
                .exceptionTimeDate(LocalDateTime.now())
                .build();

        return errorResponse;
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleRuntimeException(RuntimeException ex,HttpServletRequest request){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ex.getMessage())
                .exceptionTimeDate(LocalDateTime.now())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .path(request.getRequestURI())
                .build();

        return errorResponse;
    }
}
