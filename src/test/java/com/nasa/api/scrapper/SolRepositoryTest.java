package com.nasa.api.scrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nasa.api.scrapper.deserialization.Deserializer;
import com.nasa.api.scrapper.model.Sol;
import com.nasa.api.scrapper.model.Weather;
import com.nasa.api.scrapper.repositories.SolRepository;

/**
 * Sol Repository Unit Tests
 * 
 * @author Pierre
 *
 */
@SpringBootTest
public class SolRepositoryTest {

	@Autowired
	private SolRepository solRepository;

	private Weather weather;

	private Sol sol;

	@Autowired
	private Environment environment;

	private ResponseEntity<String> response;

	private static final Logger logger = LoggerFactory.getLogger(SolRepositoryTest.class);

	@BeforeEach
	void setUp() {
		this.response = getRestTemplate().getForEntity(environment.getProperty("api.url"), String.class);
		this.weather = Deserializer.gson.fromJson(this.response.getBody(), Weather.class);
		List<Integer> solKeys = this.weather.getSolKeys();
		this.sol = this.weather.getSols().get(solKeys.get(0));
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Test
	void saveAndDelete() {
		assertNotNull(sol);
		long beforeSave = this.solRepository.count();
		logger.info("beforeSave :: " + beforeSave);

		this.solRepository.save(sol);
		assertEquals(solRepository.existsByKey(sol.getKey()), true);
		this.solRepository.delete(sol);

		assertEquals(beforeSave, this.solRepository.count());
	}

	@Test
	void deleteAll() {
		solRepository.deleteAll();

		assertEquals(solRepository.count(), 0);
	}
}
