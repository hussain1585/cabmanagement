package com.phonpe.cabmanagement.service;

import com.phonpe.cabmanagement.domain.ServiceCities;
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
public class ServiceCitiesService
{
    @Autowired
    private ServiceCityRepository serviceCityRepository;


    public CabApplicationResponse registerServiceCity(AddServiceCityRequest addServiceCityRequest)
    {
        String city = addServiceCityRequest.getCity();
        String state = addServiceCityRequest.getState();
        String country = addServiceCityRequest.getCountry();

        AddServiceCityResponse addServiceCityResponse = AddServiceCityResponse.builder()
                .city(city)
                .state(state)
                .country(country)
                .cityRegistrationStatus(ApplicationConstants.FAILURE)
                .build();


        Optional<ServiceCities> allServiceCitiesByCityName = serviceCityRepository.findAllByCityName(city);
        if (allServiceCitiesByCityName.isEmpty())
        {
            ServiceCities serviceCity = ServiceCities.builder()
                    .city(city)
                    .state(state)
                    .country(country)
                    .build();

            serviceCityRepository.save(serviceCity);
            addServiceCityResponse.setCityRegistrationStatus(ApplicationConstants.SUCCESS);
        } else
        {
            throw new CityAlreadyRegisteredException(String.format("Service city %s from state %s in country %s is already registered", city, state, country));
        }
        return addServiceCityResponse;
    }
}
