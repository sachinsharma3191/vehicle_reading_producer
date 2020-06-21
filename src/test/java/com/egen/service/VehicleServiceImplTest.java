package com.egen.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.egen.exception.ResourceNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.egen.entity.Vehicle;
import com.egen.repository.VehicleRepository;

@RunWith(SpringRunner.class)
public class VehicleServiceImplTest {

	Logger log = Logger.getLogger(VehicleServiceImpl.class.getName());
	
	@TestConfiguration
	static class VehicleServiceConfiguration {

		@Bean
		public VehicleService getService() {
			return new VehicleServiceImpl();
		}
	}
	
	@Autowired
	VehicleService service;

	@MockBean
	VehicleRepository repo;
	
	private List<Vehicle> list;

	public static Vehicle getInstance(){
		Vehicle  v = new Vehicle();
		v.setMake("Tesla");
		v.setModel("V-3");
		v.setRedLineRpm(45);
		v.setYear(2015);
		v.setMaxFuelVolume(49);
		v.setVin("VISFSD324234");
		v.setLastServiceDate(LocalDateTime.now());
		return v;
	}

	@Before
	public void setUp() {
		Vehicle  v = getInstance();
		list = Collections.singletonList(v);
	
		Mockito.when(repo.findAll()).thenReturn(list);
		Mockito.when(repo.findByVin("VISFSD324234")).thenReturn(Optional.of(v));
		Mockito.when(repo.findByYear(2015)).thenReturn(list);
		Mockito.when(repo.findByMake("Tesla")).thenReturn(list);

	}

	@Test
	public void findAll() {
		List<Vehicle> result = service.findAll();
		Assert.assertEquals("Vehicle List should match ", list, result);
	}

	@Test
	public void findByVin() {
		String vin  = "VISFSD324234";
		Vehicle vehicle = service.findByVin(vin);
		Assert.assertEquals("Vehicle  should match with" + vin, list.get(0), vehicle);
	}

	@Test(expected = ResourceNotFoundException.class)
	public void findByVinNotFound(){
		String vin = "VISFsdSD324234";
		Vehicle vehicle = service.findByVin(vin);
		Assert.assertNotEquals("Vehicle should not match with " + vin, list.get(0), vehicle);
	}


	@Test
	public void findByYear() {
		int year = 2015;
		List<Vehicle> result = service.findByYear(year);
		Assert.assertEquals("There should be at leat vehicle with "  + year, list.get(0),result.get(0));
	}

	@Test
	public void findByYearNotFound() {
		int year = 2080;
		List<Vehicle> result = service.findByYear(2080);
		Assert.assertEquals("No vehicle list should have year "+  year, Collections.emptyList(),result);
	}

	@Test
	public void findByMake() {
		String make = "Tesla";
		List<Vehicle> result = service.findByMake(make);
		Assert.assertEquals("Vehicle make should match " + make, list.get(0),result.get(0));
	}


	@Test
	public void findByMakeNotFound() {
		String make = "Hero Cycle";
		List<Vehicle> result = service.findByMake(make);
		Assert.assertEquals("Vehicle make should not exist with " + make , Collections.emptyList(),result);
	}

}