package com.phonpe.cabmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Trip
{
    private long tripId;
    private Location startLocation;
    private Location bookedDestination;
    private Location droppedDestination;
    private LocalDate rideStartDate;
    private LocalTime rideStartTime;
    private LocalDate rideCompletionDate;
    private LocalTime rideCompletionTime;

    public Trip(Location startLocation, Location bookedDestination)
    {
        this.startLocation = startLocation;
        this.bookedDestination = bookedDestination;
        this.rideStartDate = LocalDate.now();
        this.rideStartTime = LocalTime.now();
    }

    @Override
    public String toString()
    {
        return "Trip ==> " +
                "tripId => " + tripId +
                ", startLocation => " + startLocation +
                ", bookedDestination => " + bookedDestination +
                ", droppedDestination => " + droppedDestination +
                ", rideStartDate => " + rideStartDate +
                ", rideStartTime => " + rideStartTime +
                ", rideCompletionDate => " + rideCompletionDate +
                ", rideCompletionTime => " + rideCompletionTime;
    }
}
