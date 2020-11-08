package com.nasa.api.scrapper.model;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Sol Model
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

	public Sol(int key, Season season, Instant firstUTC, Instant lastUTC, Sensor atmosphericTemperature,
			Sensor atmosphericPressure, Sensor horizontalWindSpeed) {
		super();
		this.key = key;
		this.season = season;
		this.firstUTC = firstUTC;
		this.lastUTC = lastUTC;
		this.atmosphericTemperature = atmosphericTemperature;
		this.atmosphericPressure = atmosphericPressure;
		this.horizontalWindSpeed = horizontalWindSpeed;
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

	@Override
	public String toString() {
		return "Sol [key=" + key + ", season=" + season + ", firstUTC=" + firstUTC + ", lastUTC=" + lastUTC
				+ ", atmosphericTemperature=" + atmosphericTemperature + ", atmosphericPressure=" + atmosphericPressure
				+ ", horizontalWindSpeed=" + horizontalWindSpeed + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atmosphericPressure == null) ? 0 : atmosphericPressure.hashCode());
		result = prime * result + ((atmosphericTemperature == null) ? 0 : atmosphericTemperature.hashCode());
		result = prime * result + ((firstUTC == null) ? 0 : firstUTC.hashCode());
		result = prime * result + ((horizontalWindSpeed == null) ? 0 : horizontalWindSpeed.hashCode());
		result = prime * result + key;
		result = prime * result + ((lastUTC == null) ? 0 : lastUTC.hashCode());
		result = prime * result + ((season == null) ? 0 : season.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sol other = (Sol) obj;
		if (atmosphericPressure == null) {
			if (other.atmosphericPressure != null)
				return false;
		} else if (!atmosphericPressure.equals(other.atmosphericPressure))
			return false;
		if (atmosphericTemperature == null) {
			if (other.atmosphericTemperature != null)
				return false;
		} else if (!atmosphericTemperature.equals(other.atmosphericTemperature))
			return false;
		if (firstUTC == null) {
			if (other.firstUTC != null)
				return false;
		} else if (!firstUTC.equals(other.firstUTC))
			return false;
		if (horizontalWindSpeed == null) {
			if (other.horizontalWindSpeed != null)
				return false;
		} else if (!horizontalWindSpeed.equals(other.horizontalWindSpeed))
			return false;
		if (key != other.key)
			return false;
		if (lastUTC == null) {
			if (other.lastUTC != null)
				return false;
		} else if (!lastUTC.equals(other.lastUTC))
			return false;
		if (season != other.season)
			return false;
		return true;
	}

}
