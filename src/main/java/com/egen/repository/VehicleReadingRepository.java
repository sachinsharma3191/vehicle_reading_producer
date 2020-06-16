package com.egen.repository;

import com.egen.entity.VehicleReading;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleReadingRepository extends JpaRepository<VehicleReading,String>  {

	Optional<VehicleReading> findByVin(String vin);
}
