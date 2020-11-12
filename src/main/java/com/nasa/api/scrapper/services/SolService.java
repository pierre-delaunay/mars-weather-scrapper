package com.nasa.api.scrapper.services;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nasa.api.scrapper.model.Sol;

/**
 * Sol Service
 * 
 * @author Pierre
 *
 */
@Component
public interface SolService {

	/**
	 * Save Sol.
	 * 
	 * @param Sol
	 * @return saved Sol
	 */
	Sol save(Sol sol);

	/**
	 * Retrieve all Sols.
	 * 
	 * @return Iterable<Sol>
	 */
	Iterable<Sol> findAll();

	/**
	 * Retrieve Sol by its key.
	 * 
	 * @param key
	 * @return Sol
	 */
	Sol findByKey(int key);

	/**
	 * Retrieve Sol by its key.
	 * 
	 * @param key
	 * @return Optional<Sol>
	 */
	Optional<Sol> findById(long id);

	/**
	 * Delete Sol by key.
	 * 
	 * @param key
	 */
	void deleteSolByKey(int key);

	/**
	 * Delete Sol by id.
	 * 
	 * @param id
	 */
	void deleteSolById(long id);

	/**
	 * Returns status over a existing Sol.
	 * 
	 * @param key
	 * @return true if Sol already exists, false otherwise
	 */
	boolean isSolExist(int key);
}
