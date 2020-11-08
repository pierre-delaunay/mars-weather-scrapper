package com.nasa.api.scrapper.deserialization;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.nasa.api.scrapper.model.Sensor;
import com.nasa.api.scrapper.model.Sensor.MeasurementUnit;

/**
 * Sensor Deserializer
 * 
 * @author Pierre
 *
 */
public class SensorDeserializer implements JsonDeserializer<Sensor> {

	@Override
	public Sensor deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject jsonObject = json.getAsJsonObject();

		MeasurementUnit unit = MeasurementUnit.fromString(jsonObject.get("unit").getAsString());
		int sampleCount = jsonObject.get("ct").getAsInt();
		Double sampleAverage = jsonObject.get("av").getAsDouble();
		Double sampleMinimum = jsonObject.get("mn").getAsDouble();
		Double sampleMaximum = jsonObject.get("mx").getAsDouble();

		return new Sensor(unit, sampleCount, sampleAverage, sampleMinimum, sampleMaximum);
	}

}
