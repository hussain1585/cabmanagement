package com.phonpe.cabmanagement.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CabAlreadyRegisteredException extends RuntimeException
{
    public CabAlreadyRegisteredException(String message)
    {
        super(message);
        log.error("CabAlreadyRegisteredException with error : {}", message);
    }
}
