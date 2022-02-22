package com.phonpe.cabmanagement.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RiderAlreadyRegisteredException extends RuntimeException
{
    public RiderAlreadyRegisteredException(String message)
    {
        super(message);
        log.error("RiderAlreadyRegisteredException with error : {}", message);
    }
}
