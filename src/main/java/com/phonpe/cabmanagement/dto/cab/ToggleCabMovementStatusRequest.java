package com.phonpe.cabmanagement.dto.cab;

import com.phonpe.cabmanagement.enums.CabMovementStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ToggleCabMovementStatusRequest
{
    private Long cabId;
}
