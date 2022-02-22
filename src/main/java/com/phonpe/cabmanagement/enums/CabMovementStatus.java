package com.phonpe.cabmanagement.enums;

public enum CabMovementStatus
{
    IDLE, // Driver is available for booking
    OFFLINE, // Driver can not be reached by servers
    ON_TRIP; // driver is already serving a trip
}
