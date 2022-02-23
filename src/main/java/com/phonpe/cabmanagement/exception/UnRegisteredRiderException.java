package com.phonpe.cabmanagement.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnRegisteredRiderException extends RuntimeException
{
    public UnRegisteredRiderException(String message)
    {
        super(message);
        log.error("UnRegisteredRiderException with error : {}", message);
    }
}
