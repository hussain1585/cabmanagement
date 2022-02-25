package com.phonpe.cabmanagement.util;

import com.google.gson.Gson;
import com.phonpe.cabmanagement.domain.Location;
import com.phonpe.cabmanagement.dto.cab.CabChangeCabMovementStatusRequest;
import com.phonpe.cabmanagement.dto.cab.CabChangeLocationRequest;
import com.phonpe.cabmanagement.dto.cab.ToggleCabMovementStatusRequest;
import com.phonpe.cabmanagement.dto.trip.BookTripByGivenCabAndRiderRequest;
import com.phonpe.cabmanagement.dto.trip.BookTripRequest;
import com.phonpe.cabmanagement.enums.CabMovementStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class A
{
    public static void main1(String[] args)
    {
        Location location = Location
                .builder()
                .latitude(new Double(123.4))
                .longitude(new Double(123.5))
                .build();
        Gson gson = new Gson();
        CabChangeCabMovementStatusRequest cabChangeCabMovementStatusRequest = CabChangeCabMovementStatusRequest
                .builder()
                .cabId(new Long(1))
                .cabMovementStatus(CabMovementStatus.ON_TRIP)
                .build();

        CabChangeLocationRequest cabChangeLocationRequest = CabChangeLocationRequest.builder()
                .cabId(1)
                .location(location)
                .build();

        ToggleCabMovementStatusRequest toggleCabMovementStatusRequest = ToggleCabMovementStatusRequest
                .builder()
                .cabId(new Long(1))
                .build();

        String mobileNo = "8826295165";
        BookTripRequest bookTripRequest = BookTripRequest
                .builder()
                .startLocation(location)
                .bookedDestination(location)
                .rideStartDate(LocalDate.now())
                .rideStartTime(LocalTime.now())
                .riderMobileNo(mobileNo)
                .build();

        String cabRegistrationNumber = "UP-14-EQ-1371";
        BookTripByGivenCabAndRiderRequest bookTripByGivenCabAndRiderRequest = BookTripByGivenCabAndRiderRequest
                .builder()
                .startLocation(location)
                .bookedDestination(location)
                .rideStartDate(LocalDate.now())
                .rideStartTime(LocalTime.now())
                .riderMobileNo(mobileNo)
                .cabRegistrationNumber(cabRegistrationNumber)
                .build();

        System.out.println(gson.toJson(cabChangeCabMovementStatusRequest));
        System.out.println(gson.toJson(cabChangeLocationRequest));
        System.out.println(gson.toJson(toggleCabMovementStatusRequest));
        System.out.println(gson.toJson(bookTripRequest));
        System.out.println(gson.toJson(bookTripByGivenCabAndRiderRequest));


    }
}
