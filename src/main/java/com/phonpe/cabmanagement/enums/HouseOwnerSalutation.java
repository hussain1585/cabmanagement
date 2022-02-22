package com.phonpe.cabmanagement.enums;

public enum HouseOwnerSalutation
{
    C_O("C/O");

    private String value;

    HouseOwnerSalutation(String value)
    {
        this.value = value;
    }

    String getValue()
    {
        return value;
    }

}
