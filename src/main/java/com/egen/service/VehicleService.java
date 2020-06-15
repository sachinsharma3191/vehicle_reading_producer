package com.egen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.entity.Vehicle;
import com.egen.entity.VehicleReading;
import com.egen.exception.VehicleServiceException;
import com.egen.repository.VehicleReadingRepository;
import com.egen.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	VehicleReadingRepository vehicleReadingRepository;

	@Autowired
	VehicleRepository vehicleRepository;

	public String addVehicles(List<Vehicle> vehicles) {
		try {
			vehicleRepository.saveAll(vehicles);
		} catch (Exception e) {
			throw new VehicleServiceException(e.getMessage(), e.getCause());
		}

		return "Vehicles Information stored in database";
	}

	public List<Vehicle> getVehicleList() {
		List<Vehicle> list = new ArrayList<>();
		try {
			list = (List<Vehicle>) vehicleRepository.findAll();
		} catch (Exception e) {
			throw new VehicleServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	public void addVehicleReading(VehicleReading reading) {
		try {
			// vehicleRepository.save(entity)
		} catch (Exception e) {
			throw new VehicleServiceException(e.getMessage(), e.getCause());
		}
	}

	public List<VehicleReading> getAllReading() {
		List<VehicleReading> list = new ArrayList<>();
		try {
			list = (List<VehicleReading>) vehicleReadingRepository.findAll();
		} catch (Exception e) {
			throw new VehicleServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}
}
