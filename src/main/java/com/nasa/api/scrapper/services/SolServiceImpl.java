package com.nasa.api.scrapper.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.api.scrapper.ScrapperApplication;
import com.nasa.api.scrapper.model.Sol;
import com.nasa.api.scrapper.repositories.SolRepository;

/**
 * Sol Service Implementation
 * 
 * @author Pierre
 *
 */
@Service
public class SolServiceImpl implements SolService {

	@Autowired
	private SolRepository solRepository;

	private static final Logger logger = LoggerFactory.getLogger(ScrapperApplication.class);

	@Override
	public Sol save(Sol sol) {
		if (!this.solRepository.existsByKey(sol.getKey())) {
			logger.info("SolRepository :: Saving new Sol :: Key = " + sol.getKey());
			return this.solRepository.save(sol);
		}
		logger.info("SolRepository :: Sol already exists :: Key = " + sol.getKey());
		return sol;
	}

	@Override
	public Iterable<Sol> findAll() {
		return this.solRepository.findAll();
	}

	@Override
	public Sol findByKey(int key) {
		return this.solRepository.findByKey(key);
	}

	@Override
	public Optional<Sol> findById(long id) {
		return this.solRepository.findById(id);
	}

	@Override
	public void deleteSolByKey(int key) {
		logger.info("SolRepository :: Deleting Sol :: Key = " + key);
		this.solRepository.deleteByKey(key);
	}

	@Override
	public void deleteSolById(long id) {
		logger.info("SolRepository :: Deleting Sol :: ID = " + id);
		this.solRepository.deleteById(id);
	}

	@Override
	public boolean isSolExist(int key) {
		return this.solRepository.existsByKey(key);
	}

}
