package com.nasa.api.scrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nasa.api.scrapper.deserialization.Deserializer;
import com.nasa.api.scrapper.model.Weather;

/**
 * Scrapper Application Unit Tests
 * 
 * @author Pierre
 *
 */
@SpringBootTest
class ScrapperApplicationTest {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(ScrapperApplicationTest.class);

	@Autowired
	private Environment environment;

	private ResponseEntity<String> response;

	@BeforeEach
	void setUp() {
		this.response = getRestTemplate().getForEntity(environment.getProperty("api.url"), String.class);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Test
	void getResponseFromApi() {
		assertNotNull(this.response.getBody());
	}

	@Test
	void getHttpStatusFromApi_returnsHttpStatusOK() {
		assertEquals(this.response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	void getWeatherDataFromApi_returnsWeatherPojo() {
		Weather weather = Deserializer.gson.fromJson(this.response.getBody(), Weather.class);
		assertNotNull(weather);
		assertNotNull(weather.getSolKeys());
	}

}
