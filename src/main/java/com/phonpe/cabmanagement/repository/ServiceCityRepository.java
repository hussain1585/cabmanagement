package com.phonpe.cabmanagement.repository;

import com.phonpe.cabmanagement.domain.ServiceCities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceCityRepository extends JpaRepository<ServiceCities, Long>
{
    Optional<ServiceCities> findAllByCity(String cityName);
}
