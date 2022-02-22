package com.phonpe.cabmanagement.repository;

import com.phonpe.cabmanagement.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long>
{
}
