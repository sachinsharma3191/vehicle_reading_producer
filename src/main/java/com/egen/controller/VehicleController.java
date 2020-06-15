package com.egen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.egen.entity.Vehicle;
import com.egen.entity.VehicleReading;
import com.egen.response.RestResponseBuilder;
import com.egen.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@PostMapping(value = "/vehicles")
	public ResponseEntity<Object> addVehicles(@RequestBody List<Vehicle> vehicles) {
		return RestResponseBuilder.buildResponseEntity(vehicleService.addVehicles(vehicles), "Success",
				HttpStatus.CREATED);
	}

	@GetMapping(value = "/vehicles/all")
	public ResponseEntity<Object> getVehiclesList() {
		List<Vehicle> list = vehicleService.getVehicleList();
		if (list.isEmpty()) {
			return RestResponseBuilder.buildResponseEntity("No Data to Fetch", "Error", HttpStatus.NOT_FOUND);
		}
		return RestResponseBuilder.buildResponseEntity(list, "Success", HttpStatus.OK);
	}

	@PostMapping(value = "/readings")
	public ResponseEntity<Object> addVehicleReading(@Valid @RequestBody VehicleReading reading) {
		return RestResponseBuilder.buildResponseEntity("Vehicles Reading Updated", "Success", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/readings/all")
	public ResponseEntity<Object> getAllReadings() {
		List<VehicleReading> list = vehicleService.getAllReading();
		if (list.isEmpty()) {
			return RestResponseBuilder.buildResponseEntity("No Data to Fetch", "Error", HttpStatus.NOT_FOUND);
		}
		return RestResponseBuilder.buildResponseEntity(list, "Success", HttpStatus.OK);
	}

}
