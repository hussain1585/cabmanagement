package com.phonpe.cabmanagement.dto.trip;

import com.phonpe.cabmanagement.domain.Location;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookTripByGivenCabAndRiderRequest
{
    private Location startLocation;
    private Location bookedDestination;
    private LocalDate rideStartDate;
    private LocalTime rideStartTime;
    private String riderMobileNo;
    private String cabRegistrationNumber;
}
