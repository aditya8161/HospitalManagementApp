package com.jpademo.HospitalManagement.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse
{
    private String message;
    private HttpStatus httpStatus;
    private String path;
    private LocalDateTime exceptionTimeDate;
}
