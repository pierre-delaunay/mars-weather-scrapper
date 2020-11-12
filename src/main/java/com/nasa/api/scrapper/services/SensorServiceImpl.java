package com.nasa.api.scrapper.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.api.scrapper.model.Sensor;
import com.nasa.api.scrapper.repositories.SensorRepository;

/**
 * Sensor Service Implementation
 * 
 * @author Pierre
 *
 */
@Service
public class SensorServiceImpl implements SensorService {

	@Autowired
	SensorRepository sensorRepository;

	@Override
	public Sensor save(Sensor sensor) {
		return this.sensorRepository.save(sensor);
	}

	@Override
	public Iterable<Sensor> findAll() {
		return this.sensorRepository.findAll();
	}

	@Override
	public Optional<Sensor> findById(long id) {
		return this.sensorRepository.findById(id);
	}

	@Override
	public void deleteSensorById(long id) {
		this.sensorRepository.deleteById(id);
	}

}
