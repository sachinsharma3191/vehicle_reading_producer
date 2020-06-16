package com.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.egen.entity.Vehicle;
import com.egen.request.VehicleRequest;
import com.egen.response.RestResponseBuilder;
import com.egen.service.VehicleService;

@RestController
@Transactional
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@PostMapping(value = "/vehicles")
	public ResponseEntity<Object> addVehicles(@RequestBody List<Vehicle> vehicles) {
		return RestResponseBuilder.buildResponseEntity(vehicleService.saveAll(vehicles), "Success", HttpStatus.CREATED);
	}

	@GetMapping(value = "/vehicles/all")
	public ResponseEntity<Object> getVehiclesList() {
		List<Vehicle> list = vehicleService.findAll();
		if (list.isEmpty()) {
			return RestResponseBuilder.buildResponseEntity("No Data to Fetch", "Error", HttpStatus.NOT_FOUND);
		}
		return RestResponseBuilder.buildResponseEntity(list, "Success", HttpStatus.OK);
	}

	@GetMapping(value = "/vehicles/vin")
	public ResponseEntity<Object> getVehicleByVin(@RequestBody VehicleRequest request) {
		return RestResponseBuilder.buildResponseEntity(vehicleService.findByVin(request.getVin()), "Success",
				HttpStatus.OK);
	}

	@GetMapping(value = "/vehicles/make")
	public ResponseEntity<Object> getVehicleByMake(@RequestBody VehicleRequest request) {
		return RestResponseBuilder.buildResponseEntity(vehicleService.findByMake(request.getMake()), "Success",
				HttpStatus.OK);
	}

	@GetMapping(value = "/vehicles/model")
	public ResponseEntity<Object> getVehicleByModel(@RequestBody VehicleRequest request) {
		return RestResponseBuilder.buildResponseEntity(vehicleService.findByModel(request.getModel()), "Success",
				HttpStatus.OK);
	}

	@GetMapping(value = "/vehicles/year")
	public ResponseEntity<Object> getVehicleByYear(@RequestBody VehicleRequest request) {
		return RestResponseBuilder.buildResponseEntity(vehicleService.findByYear(request.getYear()), "Success",
				HttpStatus.OK);
	}

}
