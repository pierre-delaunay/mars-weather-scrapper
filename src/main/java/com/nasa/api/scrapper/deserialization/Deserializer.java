package com.nasa.api.scrapper.deserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nasa.api.scrapper.model.Sensor;
import com.nasa.api.scrapper.model.Sol;
import com.nasa.api.scrapper.model.Weather;

/**
 * Deserializer
 * 
 * @author Pierre
 *
 */
public class Deserializer {

	public static Gson gson;

	static {
		GsonBuilder builder = new GsonBuilder();

		builder.registerTypeAdapter(Sensor.class, new SensorDeserializer());
		builder.registerTypeAdapter(Sol.class, new SolDeserializer());
		builder.registerTypeAdapter(Weather.class, new WeatherDeserializer());

		gson = builder.create();
	}

}
