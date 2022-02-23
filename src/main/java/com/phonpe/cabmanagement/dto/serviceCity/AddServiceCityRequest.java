package com.phonpe.cabmanagement.dto.serviceCity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AddServiceCityRequest
{
    private String city;
    private String state;
    private String country;
}
