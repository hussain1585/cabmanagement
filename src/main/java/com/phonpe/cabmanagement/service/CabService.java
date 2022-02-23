package com.phonpe.cabmanagement.service;

import com.phonpe.cabmanagement.domain.Cab;
import com.phonpe.cabmanagement.domain.Location;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.GetNearByCabsRequest;
import com.phonpe.cabmanagement.dto.cab.CabChangeLocationRequest;
import com.phonpe.cabmanagement.dto.cab.CabChangeLocationResponse;
import com.phonpe.cabmanagement.dto.cab.RegisterCabRequest;
import com.phonpe.cabmanagement.dto.cab.RegisterCabResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import com.phonpe.cabmanagement.enums.CabMovementStatus;
import com.phonpe.cabmanagement.enums.VehicleType;
import com.phonpe.cabmanagement.exception.CabAlreadyRegisteredException;
import com.phonpe.cabmanagement.exception.UnregisteredCabException;
import com.phonpe.cabmanagement.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CabService
{
    @Autowired
    private CabRepository cabRepository;

    public CabApplicationResponse registerCab(RegisterCabRequest registerCabRequest)
    {
        String registrationNumber = registerCabRequest.getRegistrationNumber();
        String vehicleBrand = registerCabRequest.getVehicleBrand();
        String vehicleModel = registerCabRequest.getVehicleModel();
        String vehicleColor = registerCabRequest.getVehicleColor();
        VehicleType vehicleType = registerCabRequest.getVehicleType();
        Location currentLocation = registerCabRequest.getCurrentLocation();

        RegisterCabResponse registerCabResponse = RegisterCabResponse.builder()
                .vehicleBrand(vehicleBrand)
                .vehicleModel(vehicleModel)
                .vehicleColor(vehicleColor)
                .vehicleType(vehicleType)
                .registrationNumber(registrationNumber)
                .currentLocation(currentLocation)
                .registrationStatus(ApplicationConstants.FAILURE)
                .build();

        Optional<Cab> allCabsByRegistrationNumber = cabRepository.findAllByRegistrationNumber(registrationNumber);

        if (allCabsByRegistrationNumber.isEmpty())
        {
            Cab cab = Cab.builder()
                    .vehicleBrand(vehicleBrand)
                    .vehicleModel(vehicleModel)
                    .vehicleColor(vehicleColor)
                    .vehicleType(vehicleType)
                    .registrationNumber(registrationNumber)
                    .currentLocation(currentLocation)
                    .cabMovementStatus(CabMovementStatus.IDLE)
                    .build();

            cabRepository.save(cab);
            registerCabResponse.setRegistrationStatus(ApplicationConstants.SUCCESS);
        } else
        {
            throw new CabAlreadyRegisteredException(String.format("Cab with registration number => %s is already registered", registrationNumber));
        }
        registerCabResponse.setCabMovementStatus(CabMovementStatus.IDLE);
        registerCabResponse.setAvailable(true);
        return registerCabResponse;
    }


    public Set<Cab> getNearByCabs(GetNearByCabsRequest getNearByCabsRequest)
    {
        return null;
    }


    public CabApplicationResponse changeLocation(CabChangeLocationRequest cabChangeLocationRequest)
    {
        long cabId = cabChangeLocationRequest.getCabId();
        Location newLocation = cabChangeLocationRequest.getLocation();

        CabChangeLocationResponse cabChangeLocationResponse = CabChangeLocationResponse.builder()
                .newLocation(newLocation)
                .build();

        Optional<Cab> cabById = cabRepository.findAllById(cabId);
        if (cabById.isEmpty())
        {
            throw new UnregisteredCabException(String.format("cab with cabId => %d is not registered", cabId));
        } else
        {
            Cab cab = cabById.get();
            cabChangeLocationResponse.setOldLocation(cab.getCurrentLocation());
            cab.setCurrentLocation(newLocation);
            cabRepository.save(cab);
        }
        return cabChangeLocationResponse;
    }
}
