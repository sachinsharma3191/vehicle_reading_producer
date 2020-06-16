package com.egen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.egen.entity.VehicleReading;
import com.egen.response.RestResponseBuilder;
import com.egen.service.VehicleReadingService;

@RestController
@Transactional
public class VehicleReadingController {

	@Autowired
	VehicleReadingService readingService;

	@PostMapping(value = "/readings")
	public ResponseEntity<Object> addVehicleReading(@Valid @RequestBody VehicleReading reading) {
		return RestResponseBuilder.buildResponseEntity(readingService.create(reading), "Success", HttpStatus.CREATED);
	}

	@GetMapping(value = "/readings/all")
	public ResponseEntity<Object> getAllReadings() {
		List<VehicleReading> list = readingService.findAll();
		if (list.isEmpty()) {
			return RestResponseBuilder.buildResponseEntity("No Data to Fetch", "Error", HttpStatus.NOT_FOUND);
		}
		return RestResponseBuilder.buildResponseEntity(list, "Success", HttpStatus.OK);
	}

	@GetMapping(value = "/readings/{vin}")
	public ResponseEntity<Object> getAllReadings(@PathVariable("vin") String vin) {
		return RestResponseBuilder.buildResponseEntity(readingService.findOne(vin), "Success", HttpStatus.OK);
	}

}
