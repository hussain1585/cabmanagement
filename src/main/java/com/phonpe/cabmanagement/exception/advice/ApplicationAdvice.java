package com.phonpe.cabmanagement.exception.advice;

import com.phonpe.cabmanagement.dto.CabApplicationExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApplicationAdvice
{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CabApplicationExceptionResponse> handleGenericException(Exception exception)
    {
        log.debug("handling API exception => Exception ");
        CabApplicationExceptionResponse cabApplicationExceptionResponse = CabApplicationExceptionResponse
                .builder()
                .error(exception.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(cabApplicationExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
