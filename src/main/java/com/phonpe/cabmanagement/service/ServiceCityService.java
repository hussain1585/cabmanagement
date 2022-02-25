package com.phonpe.cabmanagement.service;

import com.phonpe.cabmanagement.domain.ServiceCity;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.serviceCity.AddServiceCityRequest;
import com.phonpe.cabmanagement.dto.serviceCity.AddServiceCityResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import com.phonpe.cabmanagement.exception.CityAlreadyRegisteredException;
import com.phonpe.cabmanagement.repository.ServiceCityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ServiceCityService
{
    @Autowired
    private ServiceCityRepository serviceCityRepository;


    public CabApplicationResponse registerServiceCity(AddServiceCityRequest addServiceCityRequest)
    {
        log.info("Registering city as service city for cab with details => {}", addServiceCityRequest);
        String city = addServiceCityRequest.getCity();
        String state = addServiceCityRequest.getState();
        String country = addServiceCityRequest.getCountry();

        AddServiceCityResponse addServiceCityResponse = AddServiceCityResponse.builder()
                .city(city)
                .state(state)
                .country(country)
                .cityRegistrationStatus(ApplicationConstants.FAILURE)
                .build();


        Optional<ServiceCity> allServiceCitiesByCityName = serviceCityRepository.findAllByCity(city);
        if (allServiceCitiesByCityName.isEmpty())
        {
            log.debug("the city with name => {} is not already registered", city);
            ServiceCity serviceCity = ServiceCity.builder()
                    .city(city)
                    .state(state)
                    .country(country)
                    .build();

            log.info("Persisting the new service city with details => {}", serviceCity);
            serviceCityRepository.save(serviceCity);
            log.info("Persisted the new service city with details => {}", serviceCity);
            addServiceCityResponse.setCityRegistrationStatus(ApplicationConstants.SUCCESS);
        } else
        {
            log.error("Service city => {} from state => {} in country => {} is already registered", city, state, country);
            throw new CityAlreadyRegisteredException(String.format("Service city %s from state %s in country %s is already registered", city, state, country));
        }
        return addServiceCityResponse;
    }
}
