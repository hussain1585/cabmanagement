package com.phonpe.cabmanagement.dto.serviceCity;

import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AddServiceCityResponse extends CabApplicationResponse
{
    private String city;
    private String state;
    private String country;
    private String error;
    private ApplicationConstants cityRegistrationStatus;
}
