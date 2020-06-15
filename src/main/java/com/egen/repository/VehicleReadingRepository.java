package com.egen.repository;

import com.egen.entity.VehicleReading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleReadingRepository extends CrudRepository<VehicleReading,String>  {

}
