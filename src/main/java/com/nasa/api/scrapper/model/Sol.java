package com.nasa.api.scrapper.model;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Pierre
 *
 */
public class Sol {

	private int key;
	private Season season;
	private Instant firstUTC;
	private Instant lastUTC;
	private Sensor atmosphericTemperature;
	private Sensor atmosphericPressure;
	private Sensor horizontalWindSpeed;
	private Compass windDirection;

	public enum Season {
		WINTER, SPRING, SUMMER, FALL;

		private static final Map<String, Season> reverseMapping = new HashMap<String, Season>();

		public static Season fromString(String string) {
			return reverseMapping.get(string);
		}

		static {
			for (Season season : Season.values()) {
				reverseMapping.put(season.name(), season);
			}
		}
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Instant getFirstUTC() {
		return firstUTC;
	}

	public void setFirstUTC(Instant firstUTC) {
		this.firstUTC = firstUTC;
	}

	public Instant getLastUTC() {
		return lastUTC;
	}

	public void setLastUTC(Instant lastUTC) {
		this.lastUTC = lastUTC;
	}

	public Sensor getAtmosphericTemperature() {
		return atmosphericTemperature;
	}

	public void setAtmosphericTemperature(Sensor atmosphericTemperature) {
		this.atmosphericTemperature = atmosphericTemperature;
	}

	public Sensor getAtmosphericPressure() {
		return atmosphericPressure;
	}

	public void setAtmosphericPressure(Sensor atmosphericPressure) {
		this.atmosphericPressure = atmosphericPressure;
	}

	public Sensor getHorizontalWindSpeed() {
		return horizontalWindSpeed;
	}

	public void setHorizontalWindSpeed(Sensor horizontalWindSpeed) {
		this.horizontalWindSpeed = horizontalWindSpeed;
	}

	public Compass getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(Compass windDirection) {
		this.windDirection = windDirection;
	}
}
