package com.phonpe.cabmanagement.repository;

import com.phonpe.cabmanagement.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>
{
}
