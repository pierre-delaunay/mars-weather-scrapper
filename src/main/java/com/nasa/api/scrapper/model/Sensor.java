package com.nasa.api.scrapper.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Sensor Model
 * 
 * @author Pierre
 *
 */
@Entity
@Table(name = "sensor")
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "atmosphericTemperature")
	private Sol sol;

	@Enumerated(EnumType.STRING)
	private MeasurementUnit unit;

	@Column(name = "sampleCount", precision = 3, scale = 0, columnDefinition = "DECIMAL (10)")
	private int sampleCount;

	@Column(name = "sampleAverage", precision = 10, scale = 0, columnDefinition = "DECIMAL (10)")
	private Double sampleAverage;

	@Column(name = "sampleMinimum", precision = 10, scale = 0, columnDefinition = "DECIMAL (10)")
	private Double sampleMinimum;

	@Column(name = "sampleMaximum", precision = 10, scale = 0, columnDefinition = "DECIMAL (10)")
	private Double sampleMaximum;

	public enum MeasurementUnit {

		TEMPERATURE("°F"), SPEED("m/s"), PRESSURE("Pa");

		private static final Map<String, MeasurementUnit> reverseMapping = new HashMap<String, MeasurementUnit>();
		private final String unit;

		private MeasurementUnit(String unit) {
			this.unit = unit;
		}

		public String getUnit() {
			return this.unit;
		}

		public static MeasurementUnit fromString(String string) {
			return reverseMapping.get(string);
		}

		static {
			for (MeasurementUnit unit : MeasurementUnit.values()) {
				reverseMapping.put(unit.name(), unit);
			}
		}

	}

	public Sensor() {
	}

	public Sensor(MeasurementUnit unit, int sampleCount, Double sampleAverage, Double sampleMinimum,
			Double sampleMaximum) {
		this.unit = unit;
		this.sampleCount = sampleCount;
		this.sampleAverage = sampleAverage;
		this.sampleMinimum = sampleMinimum;
		this.sampleMaximum = sampleMaximum;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the sol
	 */
	public Sol getSol() {
		return sol;
	}

	/**
	 * @param sol the sol to set
	 */
	public void setSol(Sol sol) {
		this.sol = sol;
	}

	/**
	 * @return the unit
	 */
	public MeasurementUnit getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(MeasurementUnit unit) {
		this.unit = unit;
	}

	/**
	 * @return the sampleCount
	 */
	public int getSampleCount() {
		return sampleCount;
	}

	/**
	 * @param sampleCount the sampleCount to set
	 */
	public void setSampleCount(int sampleCount) {
		this.sampleCount = sampleCount;
	}

	/**
	 * @return the sampleAverage
	 */
	public Double getSampleAverage() {
		return sampleAverage;
	}

	/**
	 * @param sampleAverage the sampleAverage to set
	 */
	public void setSampleAverage(Double sampleAverage) {
		this.sampleAverage = sampleAverage;
	}

	/**
	 * @return the sampleMinimum
	 */
	public Double getSampleMinimum() {
		return sampleMinimum;
	}

	/**
	 * @param sampleMinimum the sampleMinimum to set
	 */
	public void setSampleMinimum(Double sampleMinimum) {
		this.sampleMinimum = sampleMinimum;
	}

	/**
	 * @return the sampleMaximum
	 */
	public Double getSampleMaximum() {
		return sampleMaximum;
	}

	/**
	 * @param sampleMaximum the sampleMaximum to set
	 */
	public void setSampleMaximum(Double sampleMaximum) {
		this.sampleMaximum = sampleMaximum;
	}

	@Override
	public String toString() {
		return "Sensor [unit=" + unit + ", sampleCount=" + sampleCount + ", sampleAverage=" + sampleAverage
				+ ", sampleMinimum=" + sampleMinimum + ", sampleMaximum=" + sampleMaximum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sampleAverage == null) ? 0 : sampleAverage.hashCode());
		result = prime * result + sampleCount;
		result = prime * result + ((sampleMaximum == null) ? 0 : sampleMaximum.hashCode());
		result = prime * result + ((sampleMinimum == null) ? 0 : sampleMinimum.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		Sensor other = (Sensor) obj;
		if (sampleAverage == null) {
			if (other.sampleAverage != null)
				return false;
		} else if (!sampleAverage.equals(other.sampleAverage))
			return false;
		if (sampleCount != other.sampleCount)
			return false;
		if (sampleMaximum == null) {
			if (other.sampleMaximum != null)
				return false;
		} else if (!sampleMaximum.equals(other.sampleMaximum))
			return false;
		if (sampleMinimum == null) {
			if (other.sampleMinimum != null)
				return false;
		} else if (!sampleMinimum.equals(other.sampleMinimum))
			return false;
		if (unit != other.unit)
			return false;
		return true;
	}

}
