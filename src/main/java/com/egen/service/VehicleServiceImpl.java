package com.egen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egen.entity.Vehicle;
import com.egen.exception.VehicleServiceException;
import com.egen.exception.ResourceNotFoundException;
import com.egen.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository repository;

	@Override
	public List<Vehicle> findAll() {
		return repository.findAll();
	}

	@Override
	public Vehicle findOne(String vin) {
		return repository.findByVin(vin)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle with vin " + vin + " not found"));
	}

	@Override
	public Vehicle create(Vehicle vehicle) {
		try {
			Optional<Vehicle> existing = repository.findByVin(vehicle.getVin());
			if (!existing.isPresent()) {
				return repository.save(vehicle);
			} else if (existing.isPresent()) {
				int saved = repository.updateVehicle(vehicle.getVin(), vehicle.getMake(), vehicle.getModel(),
						vehicle.getYear(), vehicle.getRedLineRpm(), vehicle.getLastServiceDate(),
						vehicle.getMaxFuelVolume());
				return saved == 1 ? vehicle : Vehicle.getEmptyInstance();
			}
		} catch (Exception e) {
			throw new VehicleServiceException("Failed to save ", e.getCause());
		}
		return vehicle;
	}

	@Override
	public Vehicle update(String vin, Vehicle vehicle) {
		Optional<Vehicle> existing = repository.findByVin(vin);
		if (!existing.isPresent()) {
			throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
		}
		return repository.save(vehicle);
	}

	@Override
	public void delete(String vin) {
		Optional<Vehicle> existing = repository.findByVin(vin);
		if (!existing.isPresent()) {
			throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
		}
		repository.delete(existing.get());
	}

	@Override
	public Vehicle findByVin(String vin) {
		Optional<Vehicle> existing = repository.findByVin(vin);
		if (!existing.isPresent()) {
			throw new ResourceNotFoundException("Vehicle with id " + vin + " doesn't exist.");
		}
		return existing.get();
	}

	@Override
	public List<Vehicle> findByYear(int year) {
		return repository.findByYear(year);
	}

	@Override
	public List<Vehicle> findByMake(String make) {
		return repository.findByMake(make);
	}

	@Override
	public List<Vehicle> findByModel(String model) {
		return repository.findByModel(model);
	}

	@Override
	public String saveAll(List<Vehicle> vehicles) {
		try {
			repository.saveAll(vehicles);
		} catch (Exception e) {
			throw new VehicleServiceException("Failed to save ", e.getCause());
		}
		return "Saved";
	}
}
