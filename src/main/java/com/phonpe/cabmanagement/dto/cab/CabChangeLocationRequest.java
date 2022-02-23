package com.phonpe.cabmanagement.dto.cab;

import com.phonpe.cabmanagement.domain.Location;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CabChangeLocationRequest
{
    private long cabId;
    private Location location;
}
