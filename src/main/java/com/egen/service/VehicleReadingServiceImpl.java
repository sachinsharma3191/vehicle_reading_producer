package com.egen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.egen.dto.VehicleAlert;
import com.egen.entity.Tires;
import com.egen.entity.Vehicle;
import com.egen.entity.VehicleReading;
import com.egen.enums.AlertPriority;
import com.egen.exception.ResourceNotFoundException;
import com.egen.exception.VehicleServiceException;
import com.egen.repository.VehicleReadingRepository;
import com.egen.repository.VehicleRepository;
import com.egen.utils.CommonUtils;

@Service
@Transactional
public class VehicleReadingServiceImpl implements VehicleReadingService {

	@Autowired
	VehicleReadingRepository repository;

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	RestTemplate restTemplate;

	
	public VehicleReadingServiceImpl() {
		super();
	}

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
	public VehicleReading findOne(String vin) {
		return repository.findByVin(vin)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle Reading with vin " + vin + " not found"));
	}

	@Override
	public VehicleReading create(VehicleReading reading) {
		try {
			createAlert(reading);
			return repository.save(reading);
		} catch (Exception e) {
			throw new VehicleServiceException("Failed to save ", e.getCause());
		}
	}

	@Override
	public boolean createAlert(VehicleReading reading) {
		String vin = reading.getVin();
		Optional<Vehicle> exist = vehicleRepository.findByVin(vin);
		if (exist.isEmpty()) {
			throw new VehicleServiceException("No vehicle found with " + vin + " Cannot create alert");
		}
		Vehicle vehicle = exist.get();
		if (reading.getEngineRpm() > vehicle.getRedLineRpm()) {
			VehicleAlert alert = VehicleAlert.builder().vin(vehicle.getVin()).priority(AlertPriority.HIGH.getPriority())
					.build();
			return sendRequest(alert);
		}
		if (reading.getFuelVolume() < vehicle.getMaxFuelVolume() / 10) {
			VehicleAlert alert = VehicleAlert.builder().vin(vehicle.getVin())
					.priority(AlertPriority.MEDIUM.getPriority()).build();
			return sendRequest(alert);
		} else {
			Tires tires = reading.getTires();
			VehicleAlert alert = null;
			if (reading.isCheckEngineLightOn()) {
				alert = VehicleAlert.builder().vin(vehicle.getVin()).priority(AlertPriority.LOW.getPriority()).build();
			}
			if (reading.isEngineCoolantLow()) {
				alert = VehicleAlert.builder().vin(vehicle.getVin()).priority(AlertPriority.LOW.getPriority()).build();
			}
			if (tires.getFrontLeft() > 36 | tires.getFrontRight() < 32) {
				alert = VehicleAlert.builder().vin(vehicle.getVin()).priority(AlertPriority.LOW.getPriority()).build();
			}
			if (tires.getFrontRight() > 36 | tires.getFrontRight() < 32) {
				alert = VehicleAlert.builder().vin(vehicle.getVin()).priority(AlertPriority.LOW.getPriority()).build();
			}
			if (tires.getRearLeft() < 32 | tires.getRearLeft() < 32) {
				alert = VehicleAlert.builder().vin(vehicle.getVin()).priority(AlertPriority.LOW.getPriority()).build();
			}
			if (tires.getRearRight() > 36 | tires.getRearRight() < 32) {
				alert = VehicleAlert.builder().vin(vehicle.getVin()).priority(AlertPriority.LOW.getPriority()).build();
			}
			return sendRequest(alert);
		}

	}

	public boolean sendRequest(VehicleAlert alert) {
		try {
			Object response = restTemplate.postForObject("http://localhost:9045/alert/create", alert, Object.class);
			if (CommonUtils.isObjectEmptyOrNull(response)) {
				return false;
			}
		} catch (Exception e) {
			throw new VehicleServiceException("Failed to save alerts", e.getCause());
		}
		return true;
	}

	@Override
	public VehicleReading update(String vin, VehicleReading reading) {
		Optional<VehicleReading> existing = repository.findByVin(vin);
		if (!existing.isPresent()) {
			throw new ResourceNotFoundException("Vehicle Reading with vin " + vin + " doesn't exist.");
		}
		return repository.save(reading);
	}

	@Override
	public void delete(String vin) {
		Optional<VehicleReading> existing = repository.findByVin(vin);
		if (!existing.isPresent()) {
			throw new ResourceNotFoundException("Vehicle Reading with vin " + vin + " doesn't exist.");
		}
		repository.delete(existing.get());
	}

}
