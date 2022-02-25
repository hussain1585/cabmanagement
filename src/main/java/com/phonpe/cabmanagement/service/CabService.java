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
import com.phonpe.cabmanagement.repository.CabEventEntityRepository;
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

    @Autowired
    private CabEventEntityRepository cabEventEntityRepository;

    public CabApplicationResponse registerCab(RegisterCabRequest registerCabRequest)
    {
        log.debug("registering cab with registration number => {}", registerCabRequest.getRegistrationNumber());
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
            log.debug("no cab already exists with registration number => {}", registerCabRequest.getRegistrationNumber());
            Cab cab = Cab.builder()
                    .vehicleBrand(vehicleBrand)
                    .vehicleModel(vehicleModel)
                    .vehicleColor(vehicleColor)
                    .vehicleType(vehicleType)
                    .registrationNumber(registrationNumber)
                    .currentLocation(currentLocation)
                    .cabMovementStatus(CabMovementStatus.IDLE)
                    .build();

            log.debug("Persisting cab with registration number => {}", registerCabRequest.getRegistrationNumber());
            cabRepository.save(cab);
            registerCabResponse.setRegistrationStatus(ApplicationConstants.SUCCESS);
        } else
        {
            log.debug("Cab already exists with registration number => {}", registerCabRequest.getRegistrationNumber());
            throw new CabAlreadyRegisteredException(String.format("Cab with registration number => %s is already registered", registrationNumber));
        }
        registerCabResponse.setCabMovementStatus(CabMovementStatus.IDLE);
        registerCabResponse.setAvailable(true);
        return registerCabResponse;
    }


    public Set<Cab> getNearByCabs(GetNearByCabsRequest getNearByCabsRequest)
    {
        log.debug("Fetch near by cabs in the proximity of user location => {}", getNearByCabsRequest.getLocation());
        return null;
    }


    public CabApplicationResponse changeLocation(CabChangeLocationRequest cabChangeLocationRequest)
    {
        log.debug("Changing the location of cab => {} with new location => {}", cabChangeLocationRequest.getCabId(), cabChangeLocationRequest.getLocation());
        long cabId = cabChangeLocationRequest.getCabId();
        Location newLocation = cabChangeLocationRequest.getLocation();

        CabChangeLocationResponse cabChangeLocationResponse = CabChangeLocationResponse.builder()
                .newLocation(newLocation)
                .cabId(cabId)
                .build();

        Optional<Cab> cabById = cabRepository.findAllByCabId(cabId);
        if (cabById.isEmpty())
        {
            log.error("cab with cabId => {} does not exist", cabId);
            throw new UnregisteredCabException(String.format("cab with cabId => %d does not exist", cabId));
        } else
        {
            log.debug("cab with cabId => {} exists", cabId);
            Cab cab = cabById.get();
            Location oldLocation = cab.getCurrentLocation();
            cabChangeLocationResponse.setOldLocation(oldLocation);
            cabChangeLocationResponse.setLocationUpdateStatus(ApplicationConstants.SUCCESS);
            cab.setCurrentLocation(newLocation);
            log.debug("Persisting newLocation => {} replacing oldLocation => {} for cab =>", newLocation, oldLocation, cabId);
            cabRepository.save(cab);
            log.debug("Persisted newLocation => {} replacing oldLocation => {} for cab =>", newLocation, oldLocation, cabId);
        }
        return cabChangeLocationResponse;
    }

    public CabApplicationResponse changeCabMovementStatus(CabChangeCabMovementStatusRequest cabChangeCabMovementStatusRequest)
    {
        log.debug("Changing Cab movement status to new status => {}", cabChangeCabMovementStatusRequest.getCabMovementStatus());
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
            log.error("cab with cabId => {} does not exist", cabId);
            throw new UnregisteredCabException(String.format("cab with cabId => %d does not exist", cabId));
        } else
        {
            log.debug("cab with cabId => {} does exists", cabId);
            Cab cab = cabById.get();
            CabMovementStatus oldCabMovementStatus = cab.getCabMovementStatus();
            if (oldCabMovementStatus == newCabMovementStatus)
            {
                log.debug("Cab with cabId => {} already has the cabMovementStatus => {}", cabId, newCabMovementStatus);
            } else
            {
                log.debug("Updating cab movement status for cabId => from {} to {}", cabId, oldCabMovementStatus, newCabMovementStatus);
                cabChangeCabMovementStatusResponse.setOldCabMovementStatus(oldCabMovementStatus);
                cab.setCabMovementStatus(newCabMovementStatus);
                cabChangeCabMovementStatusResponse.setCabMovementStatusChangeStatus(ApplicationConstants.SUCCESS);
                log.debug("Persisting cab movement status for cabId => from {} to {}", cabId, oldCabMovementStatus, newCabMovementStatus);
                cabRepository.save(cab);
                log.debug("Persisted cab movement status for cabId => from {} to {}", cabId, oldCabMovementStatus, newCabMovementStatus);
            }
        }
        return cabChangeCabMovementStatusResponse;
    }

    public CabApplicationResponse toggleCabMovementStatus(ToggleCabMovementStatusRequest toggleCabMovementStatusRequest)
    {
        log.debug("Toggling the cabMovement status");
        long cabId = toggleCabMovementStatusRequest.getCabId();
        ToggleCabMovementStatusResponse toggleCabMovementStatusResponse = ToggleCabMovementStatusResponse.builder()
                .cabId(cabId)
                .build();

        Optional<Cab> cabById = cabRepository.findAllByCabId(cabId);
        if (cabById.isEmpty())
        {
            log.error("cab with cabId => {} does not exist", cabId);
            throw new UnregisteredCabException(String.format("cab with cabId => %d is not registered", cabId));
        } else
        {
            Cab cab = cabById.get();
            CabMovementStatus oldCabMovementStatus = cab.getCabMovementStatus();
            CabMovementStatus newCabMovementStatus = (oldCabMovementStatus == CabMovementStatus.IDLE) ? CabMovementStatus.ON_TRIP : CabMovementStatus.ON_TRIP;
            log.debug("Updating cab movement status for cabId => from {} to {}", cabId, oldCabMovementStatus, newCabMovementStatus);
            toggleCabMovementStatusResponse.setNewStatus(newCabMovementStatus);
            toggleCabMovementStatusResponse.setOldStatus(oldCabMovementStatus);
            cab.setCabMovementStatus(newCabMovementStatus);
            toggleCabMovementStatusResponse.setToggleStatus(ApplicationConstants.SUCCESS);
            log.debug("Persisting cab movement status for cabId => from {} to {}", cabId, oldCabMovementStatus, newCabMovementStatus);
            cabRepository.save(cab);
            log.debug("Persisted cab movement status for cabId => from {} to {}", cabId, oldCabMovementStatus, newCabMovementStatus);
        }
        return toggleCabMovementStatusResponse;
    }


}
