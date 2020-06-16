package com.egen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egen.entity.Vehicle;
import com.egen.exception.VehicleServiceException;
import com.egen.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository repository;

	@Override
	public List<Vehicle> findAll() {
		List<Vehicle> list = new ArrayList<>();
		try {
			list = (List<Vehicle>) repository.findAll();
		} catch (Exception e) {
			throw new VehicleServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public Vehicle findOne(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new VehicleServiceException("Vehicle  with id" + id + " not found"));
	}

	@Override
	public Vehicle create(Vehicle vehicle) {
		try {
			return repository.save(vehicle);
		} catch (Exception e) {
			throw new VehicleServiceException("Failed to save ", e.getCause());
		}
	}

	@Override
	public Vehicle update(String id, Vehicle vehicle) {
		Optional<Vehicle> existing = repository.findById(id);
		if (!existing.isPresent()) {
			throw new VehicleServiceException("Employee with id " + id + " doesn't exist.");
		}
		return repository.save(vehicle);
	}

	@Override
	public void delete(String id) {
		Optional<Vehicle> existing = repository.findById(id);
		if (!existing.isPresent()) {
			throw new VehicleServiceException("Employee with id " + id + " doesn't exist.");
		}
		repository.delete(existing.get());

	}

	@Override
	public Vehicle findByVin(String vin) {
		Optional<Vehicle> existing = repository.findByVin(vin);
		if (!existing.isPresent()) {
			throw new VehicleServiceException("Employee with id " + vin + " doesn't exist.");
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
}
