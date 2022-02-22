package com.phonpe.cabmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "trip")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Trip
{
    @Id
    @Column(name = "trip_id")
    private long tripId;

    @Transient
    private Location startLocation;

    @Transient
    private Location bookedDestination;

    @Transient
    private Location droppedDestination;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bill bill;

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
