package com.phonpe.cabmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Cab
{
    private long cabId;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleColor;
    private String registrationNumber;
    private Location currentLocation;
    private boolean isAvailable;

    public Cab(String registrationNumber)
    {
        this.registrationNumber = registrationNumber;
        this.isAvailable = true;
    }

    @Override
    public String toString()
    {
        return "Cab ==> " +
                "cabId => " + cabId +
                ", vehicleBrand => " + vehicleBrand +
                ", vehicleModel => " + vehicleModel +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", registrationNumber => " + registrationNumber +
                ", isAvailable => " + isAvailable +
                ", currentLocation => " + currentLocation;
    }
}
