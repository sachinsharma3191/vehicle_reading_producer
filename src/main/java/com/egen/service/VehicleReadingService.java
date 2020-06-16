package com.egen.service;

import java.util.List;

import com.egen.entity.VehicleReading;

public interface VehicleReadingService {

	List<VehicleReading> findAll();

	VehicleReading findOne(String id);

	public VehicleReading create(VehicleReading reading);

	public VehicleReading update(String id, VehicleReading reading);

	void delete(String id);
}
