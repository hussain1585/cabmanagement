package com.phonpe.cabmanagement.service;

import com.phonpe.cabmanagement.domain.Address;
import com.phonpe.cabmanagement.domain.Rider;
import com.phonpe.cabmanagement.domain.ServiceCity;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.rider.RegisterRiderRequest;
import com.phonpe.cabmanagement.dto.rider.RegisterRiderResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import com.phonpe.cabmanagement.exception.CityWithNoServiceException;
import com.phonpe.cabmanagement.exception.RiderAlreadyRegisteredException;
import com.phonpe.cabmanagement.repository.RiderRepository;
import com.phonpe.cabmanagement.repository.ServiceCityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Qualifier(value = "riderService")
public class RiderService
{

    List<ServiceCity> allServiceCities = new ArrayList<>();
    @Autowired
    private RiderRepository riderRepository;
    @Autowired
    private ServiceCityRepository serviceCityRepository;

    public CabApplicationResponse registerRider(RegisterRiderRequest registerRiderRequest)
    {
        log.debug("Register Rider with details => {}", registerRiderRequest);
        String name = registerRiderRequest.getName();
        String mobileNo = registerRiderRequest.getMobileNo();
        RegisterRiderResponse registerRiderResponse = RegisterRiderResponse.builder()
                .name(name)
                .mobileNo(mobileNo)
                .registrationStatus(ApplicationConstants.FAILURE)
                .build();

        Optional<Rider> allRiderByMobileNo = riderRepository.findAllByMobileNo(mobileNo);

        if (allRiderByMobileNo.isEmpty())
        {
            log.debug("Rider with mobile No => {} is not registered yet");
            List<Address> addressList = registerRiderRequest.getAddresses();
            validateAddresses(addressList);

            Rider rider = Rider.builder()
                    .name(name)
                    .email(registerRiderRequest.getEmail())
                    .mobileNo(mobileNo)
                    .addresses(addressList)
                    .build();
            log.debug("Persisting the New rider for registration with details => {}", rider);
            riderRepository.save(rider);
            log.debug("Persisted the New rider for registration with details => {}", rider);
            registerRiderResponse.setRegistrationStatus(ApplicationConstants.SUCCESS);
        } else
        {
            log.error("Rider with mobile no => {} is already registered", mobileNo);
            throw new RiderAlreadyRegisteredException(String.format("Rider with mobile no %s is already registered", mobileNo));
        }
        return registerRiderResponse;
    }

    private void validateAddresses(List<Address> addressList)
    {
        log.debug("validating new address before registration whether its in service city list or not");
        if (allServiceCities.isEmpty())
        {
            log.debug("initialising list of cities with service");
            allServiceCities = serviceCityRepository.findAll();
            log.debug("initialised list of cities with total service cities => {}", allServiceCities.size());
        }
        addressList.forEach(address ->
        {
            ServiceCity serviceCity = address.getServiceCity();
            if (!allServiceCities.contains(serviceCity))
            {
                log.error("city with name => {} is not served for now", serviceCity.getCity());
                throw new CityWithNoServiceException(String.format("city with name %s is not served for now", serviceCity.getCity()));
            } else
            {
                log.debug("city with name => {} is available for service", serviceCity.getCity());
                address.setServiceCity(serviceCityRepository.findAllByCity(serviceCity.getCity()).get());
            }
        });
    }
}
