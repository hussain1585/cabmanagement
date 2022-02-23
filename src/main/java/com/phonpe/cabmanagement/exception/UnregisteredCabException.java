package com.phonpe.cabmanagement.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnregisteredCabException extends RuntimeException
{
    public UnregisteredCabException(String message)
    {
        super(message);
        log.error("UnregisteredCabException with error : {}", message);
    }
}
