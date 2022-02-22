package com.phonpe.cabmanagement.repository;

import com.phonpe.cabmanagement.domain.Cab;
import com.phonpe.cabmanagement.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long>
{
}
