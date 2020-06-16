package com.egen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.egen.entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {
	Optional<Vehicle> findByVin(String vin);

	List<Vehicle> findByMake(String make);

	List<Vehicle> findByModel(String model);

	List<Vehicle> findByYear(int year);

}
