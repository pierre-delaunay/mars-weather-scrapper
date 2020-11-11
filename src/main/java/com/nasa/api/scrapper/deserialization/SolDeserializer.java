package com.nasa.api.scrapper.deserialization;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.nasa.api.scrapper.model.Sensor;
import com.nasa.api.scrapper.model.Sol;
import com.nasa.api.scrapper.model.Sol.Season;

/**
 * Sol Deserializer
 * 
 * @author Pierre
 *
 */
public class SolDeserializer implements JsonDeserializer<Sol> {

	@Override
	public Sol deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject jsonObject = json.getAsJsonObject();

		int key = jsonObject.get("key").getAsInt();
		Season season = Season.fromString(jsonObject.get("Season").getAsString().toUpperCase());

		String firstUTC = jsonObject.get("First_UTC").getAsString();
		String lastUTC = jsonObject.get("Last_UTC").getAsString();

		Sensor atmosphericPressure;
		Sensor atmosphericTemperature;
		Sensor horizontalWindSpeed;

		try {
			jsonObject.get("AT").getAsJsonObject().addProperty("unit", "TEMPERATURE");
			atmosphericTemperature = Deserializer.gson.fromJson(jsonObject.get("AT"), Sensor.class);
		} catch (Exception e) {
			atmosphericTemperature = null;
		}
		try {
			jsonObject.get("PRE").getAsJsonObject().addProperty("unit", "PRESSURE");
			atmosphericPressure = Deserializer.gson.fromJson(jsonObject.get("PRE"), Sensor.class);
		} catch (Exception e) {
			atmosphericPressure = null;
		}
		try {
			jsonObject.get("HWS").getAsJsonObject().addProperty("unit", "SPEED");
			horizontalWindSpeed = Deserializer.gson.fromJson(jsonObject.get("HWS"), Sensor.class);
		} catch (Exception e) {
			horizontalWindSpeed = null;
		}

		return new Sol(key, season, firstUTC, lastUTC, atmosphericTemperature, atmosphericPressure,
				horizontalWindSpeed);
	}

}
