package com.egen.repo;

import java.time.LocalDateTime;

import com.egen.entity.Vehicle;
import com.egen.repository.VehicleRepository;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(properties = {
		"spring.jpa.hibernate.ddl-auto=validate"
})
public class VehicleRepositoryTest {
	@Autowired
	VehicleRepository repository;

	@Ignore
	@Test
	public void testRepository() {
		Vehicle v = new Vehicle();
		v.setMake("Tesla");
		v.setModel("V-3");
		v.setRedLineRpm(45);
		v.setYear(2015);
		v.setMaxFuelVolume(49);
		v.setVin("VISFSD324234");
		v.setLastServiceDate(LocalDateTime.now());
		repository.save(v);
		Assert.assertNotNull(v.getVin());
	}
}