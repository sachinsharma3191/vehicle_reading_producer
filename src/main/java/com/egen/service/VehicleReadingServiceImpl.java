package com.egen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egen.entity.VehicleReading;
import com.egen.exception.VehicleServiceException;
import com.egen.repository.VehicleReadingRepository;

@Service
@Transactional
public class VehicleReadingServiceImpl implements VehicleReadingService {

	@Autowired
	VehicleReadingRepository repository;

	@Override
	public List<VehicleReading> findAll() {

		List<VehicleReading> list = new ArrayList<>();
		try {
			list = (List<VehicleReading>) repository.findAll();
		} catch (Exception e) {
			throw new VehicleServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public VehicleReading findOne(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new VehicleServiceException("Reading  with id" + id + " not found"));
	}

	@Override
	public VehicleReading create(VehicleReading reading) {
		try {
			return repository.save(reading);
		} catch (Exception e) {
			throw new VehicleServiceException("Failed to save ", e.getCause());
		}
	}

	@Override
	public VehicleReading update(String id, VehicleReading reading) {
		Optional<VehicleReading> existing = repository.findById(id);
		if (!existing.isPresent()) {
			throw new VehicleServiceException("Employee with id " + id + " doesn't exist.");
		}
		return repository.save(reading);
	}

	@Override
	public void delete(String id) {
		Optional<VehicleReading> existing = repository.findById(id);
		if (!existing.isPresent()) {
			throw new VehicleServiceException("Reading with id " + id + " doesn't exist.");
		}
		repository.delete(existing.get());
	}

}
