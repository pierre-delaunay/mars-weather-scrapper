package com.nasa.api.scrapper.deserialization;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.nasa.api.scrapper.model.Sol;
import com.nasa.api.scrapper.model.Weather;

/**
 * Weather Deserializer
 * 
 * @author Pierre
 *
 */
public class WeatherDeserializer implements JsonDeserializer<Weather> {

	@Override
	public Weather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject jsonObject = json.getAsJsonObject();

		ArrayList<Integer> solKeys = new ArrayList<>();

		for (JsonElement element : jsonObject.get("sol_keys").getAsJsonArray()) {
			solKeys.add(element.getAsInt());
		}

		jsonObject.remove("sol_keys");
		jsonObject.remove("validity_checks");

		Map<Integer, Sol> solData = new HashMap<>();

		for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
			int key = Integer.parseInt(entry.getKey());
			JsonObject value = entry.getValue().getAsJsonObject();
			value.addProperty("key", key);
			solData.put(key, Deserializer.gson.fromJson(value, Sol.class));
		}

		return new Weather(solData, solKeys);
	}

}
