package com.egen.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.egen.entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {
	Optional<Vehicle> findByVin(String vin);

	List<Vehicle> findByMake(String make);

	List<Vehicle> findByModel(String model);

	List<Vehicle> findByYear(int year);

	@Modifying
	@Query("update VEHICLE v set v.make = :make,v.model = :model,v.year= :year,"
			+ "v.redlineRpm = :redlineRpm,v.lastServiceDate = :lastServiceDate,v.maxFuelVolume = :maxFuelVolume where v.vin = :vin")
	public int updateVehicle(@Param("vin") String vin, @Param("make") String make, @Param("model") String model,
			@Param("year") int year, @Param("redlineRpm") int redlineRpm,
			@Param("lastServiceDate") LocalDateTime lastServiceDate, @Param("maxFuelVolume") int maxFuelVolume);

}
