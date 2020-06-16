package com.egen.service;

import java.util.List;

import com.egen.entity.Vehicle;

public interface VehicleService {

	public List<Vehicle> findAll();

	public Vehicle findOne(String id);

	public Vehicle create(Vehicle emp);

	public Vehicle update(String id, Vehicle emp);

	public void delete(String id);

	public Vehicle findByVin(String vin);

	public List<Vehicle> findByMake(String make);

	public List<Vehicle> findByModel(String model);

	public List<Vehicle> findByYear(int year);
}
