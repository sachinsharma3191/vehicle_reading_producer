package com.egen.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

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

import com.egen.entity.Tires;
import com.egen.entity.VehicleReading;
import com.egen.exception.ResourceNotFoundException;
import com.egen.repository.VehicleReadingRepository;

@RunWith(SpringRunner.class)
public class VehicleReadingServiceImplTest {

	Logger log = Logger.getLogger(VehicleReadingServiceImplTest.class.getName());

	@TestConfiguration
	static class VehicleReadingServiceConfiguration {

		@Bean(name= "vehicleReadingService")
		public VehicleReadingService getInstance() {
			return new VehicleReadingServiceImpl();
		}
	}

	@Autowired
	VehicleReadingService service;

	@MockBean
	VehicleReadingRepository repository;

	private List<VehicleReading> list;

	@Before
	public void setUp() {
		VehicleReading reading = new VehicleReading();
		reading.setVin("1HGCR2F3XFA027534");
		reading.setLongitude(-88.144406f);
		reading.setLatitude(41.803194f);
		reading.setFuelVolume(1.5f);
		reading.setSpeed(85f);
		reading.setEngineHp(240f);
		reading.setEngineCoolantLow(true);
		reading.setCruiseControlOn(true);
		reading.setCheckEngineLightOn(false);
		reading.setEngineHp(6300f);

		Tires tires = new Tires();
		tires.setFrontLeft(34f);
		tires.setFrontRight(36f);
		tires.setRearLeft(29f);
		tires.setRearRight(34f);

		reading.setTimestamp(LocalDateTime.parse("2017-05-25T17:31:25.268Z"));
		reading.setTires(tires);

		list = Collections.singletonList(reading);

		Mockito.when(repository.findAll()).thenReturn(list);
		Mockito.when(repository.findByVin("1HGCR2F3XFA027534")).thenReturn(Optional.of(reading));

	}

	@Test
	public void findAll() {
		List<VehicleReading> result = service.findAll();
		Assert.assertEquals("Vehicle Reading List should match ", list, result);
	}

	@Test
	public void findByVin() {
		String vin = "1HGCR2F3XFA027534";
		VehicleReading vehicle = service.findOne(vin);
		Assert.assertEquals("Vehicle  should match with" + vin, list.get(0), vehicle);
	}

	@Test(expected = ResourceNotFoundException.class)
	public void findByVinNotFound() {
		String vin = "VISFsdSD324234";
		VehicleReading vehicle = service.findOne(vin);
		Assert.assertNotEquals("Vehicle should not match with " + vin, list.get(0), vehicle);
	}

}