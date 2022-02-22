package com.phonpe.cabmanagement.rest;

import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.rider.RegisterRiderRequest;
import com.phonpe.cabmanagement.service.RiderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RiderController
{
    @Autowired
    private RiderService riderService;

    @PostMapping("/register/rider")
    public CabApplicationResponse registerRider(@RequestBody RegisterRiderRequest registerRiderRequest)
    {
        return riderService.registerRider(registerRiderRequest);
    }
}
