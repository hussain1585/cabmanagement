package com.phonpe.cabmanagement.repository;

import com.phonpe.cabmanagement.domain.Cab;
import com.phonpe.cabmanagement.domain.CabEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CabEventEntityRepository extends JpaRepository<CabEventEntity, Long>
{

    Optional<Cab> findAllByRegistrationNumber(String registrationNumber);

    Optional<Cab> findAllByCabId(long cabId);
}
