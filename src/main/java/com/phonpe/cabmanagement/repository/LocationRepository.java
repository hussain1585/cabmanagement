package com.phonpe.cabmanagement.repository;

import com.phonpe.cabmanagement.domain.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Cab, Long>
{
}
