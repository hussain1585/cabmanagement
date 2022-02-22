package com.phonpe.cabmanagement.dto.rider;

import com.phonpe.cabmanagement.dto.CabManagementResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RegisterRiderResponse extends CabManagementResponse
{
    private String mobileNo;
    private String name;
    private ApplicationConstants registrationStatus;
    private String error;
}
