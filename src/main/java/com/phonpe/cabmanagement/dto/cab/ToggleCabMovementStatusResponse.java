package com.phonpe.cabmanagement.dto.cab;

import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import com.phonpe.cabmanagement.enums.CabMovementStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ToggleCabMovementStatusResponse extends CabApplicationResponse
{
    private Long cabId;
    private CabMovementStatus oldStatus;
    private CabMovementStatus newStatus;
    private ApplicationConstants toggleStatus;
    private String error;
}
