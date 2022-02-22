package com.phonpe.cabmanagement.repository;

import com.phonpe.cabmanagement.domain.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CabRepository extends JpaRepository<Cab, Long>
{

    Optional<Cab> findAllByRegistrationNumber(String registrationNumber);
}
