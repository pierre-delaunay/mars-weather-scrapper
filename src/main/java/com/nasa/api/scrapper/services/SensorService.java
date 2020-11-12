package com.nasa.api.scrapper.services;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nasa.api.scrapper.model.Sensor;

/**
 * Sensor Service
 * 
 * @author Pierre
 *
 */
@Component
public interface SensorService {

	/**
	 * Save sensor.
	 * 
	 * @param sensor
	 * @return saved Sensor
	 */
	Sensor save(Sensor sensor);

	/**
	 * Find all sensors.
	 * 
	 * @return Iterable<Sensor>
	 */
	Iterable<Sensor> findAll();

	/**
	 * Find sensor by id.
	 * 
	 * @param id
	 * @return Optional<Sensor>
	 */
	Optional<Sensor> findById(long id);

	/**
	 * Delete sensor by id.
	 * 
	 * @param id
	 */
	void deleteSensorById(long id);
}
