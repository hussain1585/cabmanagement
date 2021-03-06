package com.phonpe.cabmanagement.domain;

import com.phonpe.cabmanagement.enums.CabMovementStatus;
import com.phonpe.cabmanagement.enums.VehicleType;
import com.phonpe.cabmanagement.listener.CabEntityListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "cab")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EntityListeners(CabEntityListener.class)
public class Cab
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cabId;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleColor;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    private String registrationNumber;

    @Transient
    private Location currentLocation;

    private boolean isAvailable;

    @Enumerated(EnumType.STRING)
    private CabMovementStatus cabMovementStatus;

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
