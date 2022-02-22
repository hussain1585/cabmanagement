package com.phonpe.cabmanagement.repository;

import com.phonpe.cabmanagement.domain.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long>
{
    Optional<Rider> findAllByMobileNo(String mobileNo);
}
