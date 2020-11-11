package com.nasa.api.scrapper.services;

import java.util.List;

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
	 * Create or update existing Sol.
	 * 
	 * @param Sol
	 * @return saved Sol
	 */
	public Sol createOrUpdate(Sol sol);

	/**
	 * Retrieve all Sols.
	 * 
	 * @return list of Sols
	 */
	public List<Sol> findAll();

	/**
	 * Retrieve Sol by its key.
	 * 
	 * @param key
	 * @return Sol
	 */
	public Sol findByKey(int key);

	/**
	 * Returns status over a existing Sol.
	 * 
	 * @param key
	 * @return true if Sol already exists, false otherwise
	 */
	public boolean isSolExist(int key);
}
