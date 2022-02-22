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
public class CabManagementAdvice
{
    @ExceptionHandler(RiderAlreadyRegisteredException.class)
    public ResponseEntity<CabApplicationExceptionResponse> handleRiderAlreadyRegisteredException(RiderAlreadyRegisteredException riderAlreadyRegisteredException)
    {
        log.info("handling API exception => RiderAlreadyRegisteredException ");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        CabApplicationExceptionResponse cabApplicationExceptionResponse = CabApplicationExceptionResponse
                .builder()
                .error(riderAlreadyRegisteredException.getMessage())
                .httpStatus(httpStatus)
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(cabApplicationExceptionResponse, httpStatus);
    }

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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CabApplicationExceptionResponse> handleGenericException(Exception exception)
    {
        log.info("handling API exception => Exception ");
        CabApplicationExceptionResponse cabApplicationExceptionResponse = CabApplicationExceptionResponse
                .builder()
                .error(exception.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(cabApplicationExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
