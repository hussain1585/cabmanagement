package com.phonpe.cabmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "service_cities")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ServiceCity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceCityId;
    private String city;
    private String state;
    private String country;
}
