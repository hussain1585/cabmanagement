package com.phonpe.cabmanagement.dto.cab;

import com.phonpe.cabmanagement.domain.Location;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import com.phonpe.cabmanagement.enums.CabMovementStatus;
import com.phonpe.cabmanagement.enums.VehicleType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RegisterCabResponse extends CabApplicationResponse
{
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleColor;
    private VehicleType vehicleType;
    private String registrationNumber;
    private Location currentLocation;
    private boolean isAvailable;
    private CabMovementStatus cabMovementStatus;
    private ApplicationConstants registrationStatus;
    private String error;
}
