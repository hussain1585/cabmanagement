package com.phonpe.cabmanagement.dto.trip;

import com.phonpe.cabmanagement.domain.Bill;
import com.phonpe.cabmanagement.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookTripRequest
{
    private Location startLocation;
    private Location bookedDestination;
    private LocalDate rideStartDate;
    private LocalTime rideStartTime;
    private String RiderMobileNo;
}
