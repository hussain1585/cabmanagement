package com.phonpe.cabmanagement.dto.cab;

import com.phonpe.cabmanagement.domain.Location;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CabChangeLocationResponse extends CabApplicationResponse
{
    private Long cabId;
    private Location oldLocation;
    private Location newLocation;
    private ApplicationConstants locationUpdateStatus;
    private String error;
}
