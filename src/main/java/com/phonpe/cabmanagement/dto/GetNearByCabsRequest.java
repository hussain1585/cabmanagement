package com.phonpe.cabmanagement.dto;

import com.phonpe.cabmanagement.domain.Location;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetNearByCabsRequest
{
    private Location location;
}
