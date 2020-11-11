package com.nasa.api.scrapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.nasa.api.scrapper.deserialization.Deserializer;
import com.nasa.api.scrapper.model.Sol;
import com.nasa.api.scrapper.model.Weather;
import com.nasa.api.scrapper.services.SolService;

/**
 * Scrapper Application
 * 
 * @author Pierre
 *
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableScheduling
public class ScrapperApplication {

	@Value("${api.url}")
	private String apiUrl;

	@Autowired
	private SolService solService;

	private static final Logger logger = LoggerFactory.getLogger(ScrapperApplication.class);

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Bean
	public Weather getWeatherData() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(this.apiUrl, String.class);
		return Deserializer.gson.fromJson(response.getBody(), Weather.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ScrapperApplication.class, args);
	}

	/**
	 * Runs every five minute.
	 */
	@Scheduled(fixedRate = 300000, initialDelay = 10000)
	public void scheduleTaskWithFixedRate() {
		logger.info("Scheduled Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		Weather weather = getWeatherData();

		logger.info("Scheduled Task :: Printing weather data :: " + weather.toString());
		List<Integer> solKeys = weather.getSolKeys();
		Sol firstSol = weather.getSols().get(solKeys.get(0));

		logger.info("Scheduled Task :: createOrUpdate :: Sol " + firstSol.getKey());
		this.solService.createOrUpdate(firstSol);
	}

}
