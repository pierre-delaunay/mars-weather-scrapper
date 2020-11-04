package com.nasa.api.scrapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Pierre
 *
 */
@SpringBootApplication
public class ScrapperApplication {

	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(ScrapperApplication.class, args);
	}

}
