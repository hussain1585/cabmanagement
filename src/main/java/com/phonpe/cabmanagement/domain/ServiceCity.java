package com.phonpe.cabmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceCity that = (ServiceCity) o;
        return city.equalsIgnoreCase(that.city) && state.equalsIgnoreCase(that.state) && country.equalsIgnoreCase(that.country);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(city.toLowerCase(), state.toLowerCase(), country.toLowerCase());
    }
}
