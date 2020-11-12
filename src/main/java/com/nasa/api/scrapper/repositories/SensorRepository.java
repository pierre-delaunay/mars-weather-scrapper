package com.nasa.api.scrapper.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nasa.api.scrapper.model.Sensor;

/**
 * Sensor Repository
 * 
 * @author Pierre
 *
 */
@Repository
public interface SensorRepository extends CrudRepository<Sensor, Long> {

}
