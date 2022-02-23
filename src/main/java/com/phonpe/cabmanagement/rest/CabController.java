package com.phonpe.cabmanagement.rest;

import com.phonpe.cabmanagement.domain.Cab;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.GetNearByCabsRequest;
import com.phonpe.cabmanagement.dto.cab.CabChangeCabMovementStatusRequest;
import com.phonpe.cabmanagement.dto.cab.CabChangeLocationRequest;
import com.phonpe.cabmanagement.dto.cab.RegisterCabRequest;
import com.phonpe.cabmanagement.dto.cab.ToggleCabMovementStatusRequest;
import com.phonpe.cabmanagement.service.CabService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Slf4j
public class CabController
{

    @Autowired
    private CabService cabService;

    @PostMapping
    public Set<Cab> getNearByCabs(@RequestBody GetNearByCabsRequest getNearByCabsRequest)
    {
        log.info("fetching list of near by cabs for location => {}", getNearByCabsRequest.getLocation());
        return cabService.getNearByCabs(getNearByCabsRequest);
    }

    @PostMapping("/cab/register")
    public CabApplicationResponse registerCab(@RequestBody RegisterCabRequest registerCabRequest)
    {
        return cabService.registerCab(registerCabRequest);
    }

    @PostMapping("/cab/changeLocation")
    public CabApplicationResponse changeLocation(@RequestBody CabChangeLocationRequest cabChangeLocationRequest)
    {
        return cabService.changeLocation(cabChangeLocationRequest);
    }

    @PostMapping("/cab/changeCabMovementStatus")
    public CabApplicationResponse changeCabMovementStatus(@RequestBody CabChangeCabMovementStatusRequest cabChangeCabMovementStatusRequest)
    {
        return cabService.changeCabMovementStatus(cabChangeCabMovementStatusRequest);
    }


    @PostMapping("/cab/toggleCabMovementStatus")
    public CabApplicationResponse toggleCabMovementStatus(@RequestBody ToggleCabMovementStatusRequest toggleCabMovementStatusRequest)
    {
        return cabService.toggleCabMovementStatus(toggleCabMovementStatusRequest);
    }


}
