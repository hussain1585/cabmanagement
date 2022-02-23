package com.phonpe.cabmanagement.rest;

import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.serviceCity.AddServiceCityRequest;
import com.phonpe.cabmanagement.service.ServiceCitiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ServiceCitiesController
{
    @Autowired
    private ServiceCitiesService serviceCitiesService;

    @PostMapping("/register/servicecity")
    public CabApplicationResponse registerServiceCity(@RequestBody AddServiceCityRequest addServiceCityRequest)
    {
        return serviceCitiesService.registerServiceCity(addServiceCityRequest);
    }
}
