package com.phonpe.cabmanagement.service;

import com.phonpe.cabmanagement.domain.Rider;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.rider.RegisterRiderRequest;
import com.phonpe.cabmanagement.dto.rider.RegisterRiderResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import com.phonpe.cabmanagement.exception.RiderAlreadyRegisteredException;
import com.phonpe.cabmanagement.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RiderService
{

    @Autowired
    private RiderRepository riderRepository;

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
            Rider rider = Rider.builder()
                    .name(name)
                    .email(registerRiderRequest.getEmail())
                    .mobileNo(mobileNo)
                    .addresses(registerRiderRequest.getAddresses())
                    .build();
            riderRepository.save(rider);
            registerRiderResponse.setRegistrationStatus(ApplicationConstants.SUCCESS);
        } else
        {
            throw new RiderAlreadyRegisteredException(String.format("Rider with mobile no %s is already registered", mobileNo));
        }
        return registerRiderResponse;
    }
}
