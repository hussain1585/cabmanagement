package com.phonpe.cabmanagement.service;

import com.phonpe.cabmanagement.domain.Cab;
import com.phonpe.cabmanagement.domain.Location;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.GetNearByCabsRequest;
import com.phonpe.cabmanagement.dto.cab.*;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import com.phonpe.cabmanagement.enums.CabMovementStatus;
import com.phonpe.cabmanagement.enums.VehicleType;
import com.phonpe.cabmanagement.exception.CabAlreadyRegisteredException;
import com.phonpe.cabmanagement.exception.UnregisteredCabException;
import com.phonpe.cabmanagement.repository.CabRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Slf4j
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
                .cabId(cabId)
                .build();

        Optional<Cab> cabById = cabRepository.findAllByCabId(cabId);
        if (cabById.isEmpty())
        {
            throw new UnregisteredCabException(String.format("cab with cabId => %d is not registered", cabId));
        } else
        {
            Cab cab = cabById.get();
            cabChangeLocationResponse.setOldLocation(cab.getCurrentLocation());
            cabChangeLocationResponse.setLocationUpdateStatus(ApplicationConstants.SUCCESS);
            cab.setCurrentLocation(newLocation);
            cabRepository.save(cab);
        }
        return cabChangeLocationResponse;
    }

    public CabApplicationResponse changeCabMovementStatus(CabChangeCabMovementStatusRequest cabChangeCabMovementStatusRequest)
    {
        long cabId = cabChangeCabMovementStatusRequest.getCabId();
        CabMovementStatus newCabMovementStatus = cabChangeCabMovementStatusRequest.getCabMovementStatus();
        CabChangeCabMovementStatusResponse cabChangeCabMovementStatusResponse = CabChangeCabMovementStatusResponse.builder()
                .cabId(cabId)
                .newCabMovementStatus(newCabMovementStatus)
                .cabMovementStatusChangeStatus(ApplicationConstants.FAILURE)
                .build();

        Optional<Cab> cabById = cabRepository.findAllByCabId(cabId);
        if (cabById.isEmpty())
        {
            throw new UnregisteredCabException(String.format("cab with cabId => %d is not registered", cabId));
        } else
        {
            Cab cab = cabById.get();

            CabMovementStatus oldCabMovementStatus = cab.getCabMovementStatus();
            if (oldCabMovementStatus == newCabMovementStatus)
            {
                log.info("NEW CAB MOVEMENT STATUS IS ALREADY CURRENT STATUS");
            }
            cabChangeCabMovementStatusResponse.setOldCabMovementStatus(oldCabMovementStatus);
            cab.setCabMovementStatus(newCabMovementStatus);
            cabChangeCabMovementStatusResponse.setCabMovementStatusChangeStatus(ApplicationConstants.SUCCESS);
            cabRepository.save(cab);
        }
        return cabChangeCabMovementStatusResponse;
    }

    public CabApplicationResponse toggleCabMovementStatus(ToggleCabMovementStatusRequest toggleCabMovementStatusRequest)
    {
        long cabId = toggleCabMovementStatusRequest.getCabId();


        ToggleCabMovementStatusResponse toggleCabMovementStatusResponse = ToggleCabMovementStatusResponse.builder()
                .cabId(cabId)
                .build();

        Optional<Cab> cabById = cabRepository.findAllByCabId(cabId);
        if (cabById.isEmpty())
        {
            throw new UnregisteredCabException(String.format("cab with cabId => %d is not registered", cabId));
        } else
        {
            Cab cab = cabById.get();
            CabMovementStatus oldCabMovementStatus = cab.getCabMovementStatus();
            CabMovementStatus newCabMovementStatus = (oldCabMovementStatus == CabMovementStatus.IDLE) ? CabMovementStatus.ON_TRIP : CabMovementStatus.ON_TRIP;
            toggleCabMovementStatusResponse.setNewStatus(newCabMovementStatus);
            toggleCabMovementStatusResponse.setOldStatus(oldCabMovementStatus);
            cab.setCabMovementStatus(newCabMovementStatus);
            toggleCabMovementStatusResponse.setToggleStatus(ApplicationConstants.SUCCESS);
            cabRepository.save(cab);
        }
        return toggleCabMovementStatusResponse;
    }
}
