package com.phonpe.cabmanagement.dto.trip;

import com.phonpe.cabmanagement.domain.Location;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookTripResponse extends CabApplicationResponse
{
    private Location startLocation;
    private Location bookedDestination;
    private LocalDate rideStartDate;
    private LocalTime rideStartTime;
    private String RiderMobileNo;
    private String error;
    private ApplicationConstants bookTripStatus;
}
