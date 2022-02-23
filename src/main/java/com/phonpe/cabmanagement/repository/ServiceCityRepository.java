package com.phonpe.cabmanagement.repository;

import com.phonpe.cabmanagement.domain.ServiceCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceCityRepository extends JpaRepository<ServiceCity, Long>
{
    Optional<ServiceCity> findAllByCity(String cityName);
}
