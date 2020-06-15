package com.egen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.egen.entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,String> {

}
