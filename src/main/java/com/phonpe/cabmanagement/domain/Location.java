package com.phonpe.cabmanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Location
{
    @JsonIgnore
    private long locationId;
    private double longitude;
    private double latitude;

    @Override
    public String toString()
    {
        return "Location =>" +
                "longitude => " + longitude +
                ", latitude => " + latitude;
    }
}
