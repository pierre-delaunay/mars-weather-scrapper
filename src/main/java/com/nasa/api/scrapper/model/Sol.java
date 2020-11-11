package com.nasa.api.scrapper.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Sol Model
 * 
 * @author Pierre
 *
 */
@Entity
@Table(name = "sol")
public class Sol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Basic
	@Column(name = "solKey")
	private int key;

	@Enumerated(EnumType.STRING)
	private Season season;

	private String firstUTC;

	private String lastUTC;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "temperature_sensor_id")
	private Sensor atmosphericTemperature;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pressure_sensor_id")
	private Sensor atmosphericPressure;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "windspeed_sensor_id")
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

	public Sol() {
	}

	public Sol(int key, Season season, String firstUTC, String lastUTC, Sensor atmosphericTemperature,
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

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * @return the season
	 */
	public Season getSeason() {
		return season;
	}

	/**
	 * @param season the season to set
	 */
	public void setSeason(Season season) {
		this.season = season;
	}

	/**
	 * @return the firstUTC
	 */
	public String getFirstUTC() {
		return firstUTC;
	}

	/**
	 * @param firstUTC the firstUTC to set
	 */
	public void setFirstUTC(String firstUTC) {
		this.firstUTC = firstUTC;
	}

	/**
	 * @return the lastUTC
	 */
	public String getLastUTC() {
		return lastUTC;
	}

	/**
	 * @param lastUTC the lastUTC to set
	 */
	public void setLastUTC(String lastUTC) {
		this.lastUTC = lastUTC;
	}

	/**
	 * @return the atmosphericTemperature
	 */
	public Sensor getAtmosphericTemperature() {
		return atmosphericTemperature;
	}

	/**
	 * @param atmosphericTemperature the atmosphericTemperature to set
	 */
	public void setAtmosphericTemperature(Sensor atmosphericTemperature) {
		this.atmosphericTemperature = atmosphericTemperature;
	}

	/**
	 * @return the atmosphericPressure
	 */
	public Sensor getAtmosphericPressure() {
		return atmosphericPressure;
	}

	/**
	 * @param atmosphericPressure the atmosphericPressure to set
	 */
	public void setAtmosphericPressure(Sensor atmosphericPressure) {
		this.atmosphericPressure = atmosphericPressure;
	}

	/**
	 * @return the horizontalWindSpeed
	 */
	public Sensor getHorizontalWindSpeed() {
		return horizontalWindSpeed;
	}

	/**
	 * @param horizontalWindSpeed the horizontalWindSpeed to set
	 */
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
