package com.phonpe.cabmanagement.enums;

public enum ApplicationConstants
{
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE");

    private String value;

    ApplicationConstants(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
