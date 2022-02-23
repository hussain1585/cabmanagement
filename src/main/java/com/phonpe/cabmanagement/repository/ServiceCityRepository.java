package com.phonpe.cabmanagement.repository;

import com.phonpe.cabmanagement.domain.ServiceCities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceCityRepository extends JpaRepository<ServiceCities, Long>
{
    Optional<ServiceCities> findAllByCityName(String cityName);
}
