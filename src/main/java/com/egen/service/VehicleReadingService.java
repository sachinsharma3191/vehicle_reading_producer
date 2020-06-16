package com.egen.service;

import java.util.List;

import com.egen.entity.VehicleReading;

public interface VehicleReadingService {

	public List<VehicleReading> findAll();

	public VehicleReading findOne(String vin);

	public VehicleReading create(VehicleReading reading);

	public VehicleReading update(String id, VehicleReading reading);

	void delete(String id);
}
