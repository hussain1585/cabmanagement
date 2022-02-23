package com.phonpe.cabmanagement.exception.advice;

import com.phonpe.cabmanagement.dto.CabApplicationExceptionResponse;
import com.phonpe.cabmanagement.exception.CabAlreadyRegisteredException;
import com.phonpe.cabmanagement.exception.RiderAlreadyRegisteredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class CabControllerAdvice
{
    @ExceptionHandler(CabAlreadyRegisteredException.class)
    public ResponseEntity<CabApplicationExceptionResponse> handleCabAlreadyRegisteredException(CabAlreadyRegisteredException cabAlreadyRegisteredException)
    {
        log.debug("handling API exception => CabAlreadyRegisteredException ");
        //        ZonedDateTime now = ZonedDateTime.now();
        CabApplicationExceptionResponse cabApplicationExceptionResponse = CabApplicationExceptionResponse
                .builder()
                .error(cabAlreadyRegisteredException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(cabApplicationExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}