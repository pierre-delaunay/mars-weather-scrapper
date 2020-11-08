package com.nasa.api.scrapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Scrapper Application
 * 
 * @author Pierre
 *
 */
@SpringBootApplication
public class ScrapperApplication {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(ScrapperApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScrapperApplication.class, args);

	}

}
