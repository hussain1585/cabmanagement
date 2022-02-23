package com.phonpe.cabmanagement.service;

import com.phonpe.cabmanagement.domain.Address;
import com.phonpe.cabmanagement.domain.Rider;
import com.phonpe.cabmanagement.domain.ServiceCity;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.rider.RegisterRiderRequest;
import com.phonpe.cabmanagement.dto.rider.RegisterRiderResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import com.phonpe.cabmanagement.exception.RiderAlreadyRegisteredException;
import com.phonpe.cabmanagement.repository.RiderRepository;
import com.phonpe.cabmanagement.repository.ServiceCityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RiderService
{

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private ServiceCityRepository serviceCityRepository;

    public CabApplicationResponse registerRider(RegisterRiderRequest registerRiderRequest)
    {
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
            List<Address> addressList = registerRiderRequest.getAddresses();
            validateAddresses(addressList);

            Rider rider = Rider.builder()
                    .name(name)
                    .email(registerRiderRequest.getEmail())
                    .mobileNo(mobileNo)
                    .addresses(addressList)
                    .build();
            riderRepository.save(rider);
            registerRiderResponse.setRegistrationStatus(ApplicationConstants.SUCCESS);
        } else
        {
            throw new RiderAlreadyRegisteredException(String.format("Rider with mobile no %s is already registered", mobileNo));
        }
        return registerRiderResponse;
    }

    private void validateAddresses(List<Address> addressList)
    {
        List<ServiceCity> allServiceCities = serviceCityRepository.findAll();

        for (Address address : addressList)
        {
            boolean contains = allServiceCities.contains(address.getServiceCity());
            log.info("contains : {}", contains);
        }

        //        List<String> allRegisteredCityNameList = serviceCityRepository.findAll().stream().map(currentServiceCity -> currentServiceCity.getCity()).collect(Collectors.toList());
        //
        //
        //        List<String> citylist = addressList.stream().map(p -> p.getCity()).collect(Collectors.toList());
        //        citylist.forEach(cityName ->
        //        {
        //            if (!allRegisteredCityNameList.contains(cityName))
        //            {
        //                throw new CityWithNoServiceException(String.format("city with name %s is not served fro now", cityName));
        //            }
        //        });
    }
}
