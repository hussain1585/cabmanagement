package com.phonpe.cabmanagement.exception.advice;

import com.phonpe.cabmanagement.dto.CabApplicationExceptionResponse;
import com.phonpe.cabmanagement.exception.CityWithNoServiceException;
import com.phonpe.cabmanagement.exception.RiderAlreadyRegisteredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class RiderControllerAdvice
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

    @ExceptionHandler(CityWithNoServiceException.class)
    public ResponseEntity<CabApplicationExceptionResponse> handleCityWithNoServiceException(CityWithNoServiceException cityWithNoServiceException)
    {
        log.info("handling API exception => CityWithNoServiceException ");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        CabApplicationExceptionResponse cabApplicationExceptionResponse = CabApplicationExceptionResponse
                .builder()
                .error(cityWithNoServiceException.getMessage())
                .httpStatus(httpStatus)
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(cabApplicationExceptionResponse, httpStatus);
    }
}
