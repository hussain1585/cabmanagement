package com.phonpe.cabmanagement.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CityAlreadyRegisteredException extends RuntimeException
{
    public CityAlreadyRegisteredException(String message)
    {
        super(message);
        log.error("CityAlreadyRegisteredException with error : {}", message);
    }
}
