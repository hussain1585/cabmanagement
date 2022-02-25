package com.phonpe.cabmanagement.domain;

import com.phonpe.cabmanagement.enums.CabMovementStatus;
import com.phonpe.cabmanagement.enums.VehicleType;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CabEvent
{
    private long cabEventId;
    private long cabId;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleColor;
    private VehicleType vehicleType;
    private String registrationNumber;
    private Location currentLocation;
    private boolean isAvailable;
    private CabMovementStatus cabMovementStatus;

    public CabEvent(Cab cab)
    {
        this.cabId = cab.getCabId();
        this.vehicleBrand = cab.getVehicleBrand();
        this.vehicleModel = cab.getVehicleModel();
        this.vehicleColor = cab.getVehicleColor();
        this.vehicleType = cab.getVehicleType();
        this.registrationNumber = cab.getRegistrationNumber();
        this.currentLocation = cab.getCurrentLocation();
        this.isAvailable = cab.isAvailable();
        this.cabMovementStatus = cab.getCabMovementStatus();
    }

    @Override
    public String toString()
    {
        return "CabEvent ==> " +
                " cabEventId => " + cabEventId +
                " cabId => " + cabId +
                " vehicleBrand => '" + vehicleBrand +
                " vehicleModel => '" + vehicleModel +
                " vehicleColor => '" + vehicleColor +
                " vehicleType => " + vehicleType +
                " registrationNumber => '" + registrationNumber +
                " currentLocation => " + currentLocation +
                " isAvailable => " + isAvailable +
                " cabMovementStatus => " + cabMovementStatus;
    }
}
