package com.nasa.api.scrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
 * Scrapper Application Unit Test
 * 
 * @author Pierre
 *
 */
@SpringBootTest
class ScrapperApplicationTest {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(ScrapperApplicationTest.class);

	@Autowired
	private Environment env;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Test
	void getResponseFromApi() {
		ResponseEntity<String> response = getRestTemplate().getForEntity(env.getProperty("api.url"), String.class);
		assertNotNull(response.getBody());
	}

	@Test
	void getHttpStatusFromApi_returnsHttpStatusOK() {
		ResponseEntity<String> response = getRestTemplate().getForEntity(env.getProperty("api.url"), String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	void getWeatherDataFromApi_returnsWeatherPojo() {
		ResponseEntity<String> response = getRestTemplate().getForEntity(env.getProperty("api.url"), String.class);

		Weather weather = Deserializer.gson.fromJson(response.getBody(), Weather.class);
		assertNotNull(weather);
		assertNotNull(weather.getSolKeys());
	}

}
