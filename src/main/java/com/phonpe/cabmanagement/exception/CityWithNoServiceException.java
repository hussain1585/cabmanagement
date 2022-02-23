package com.phonpe.cabmanagement.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CityWithNoServiceException extends RuntimeException
{
    public CityWithNoServiceException(String message)
    {
        super(message);
        log.error("CityWithNoServiceException with error : {}", message);
    }
}
