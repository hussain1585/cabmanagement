package com.phonpe.cabmanagement.dto.trip;

import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookTripResponse extends CabApplicationResponse
{
    private long Id;
}
