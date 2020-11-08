package com.nasa.api.scrapper.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Sensor Model
 * 
 * @author Pierre
 *
 */
public class Sensor {

	private MeasurementUnit unit;
	private int sampleCount;
	private Double sampleAverage;
	private Double sampleMinimum;
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

	public Sensor(MeasurementUnit unit, int sampleCount, Double sampleAverage, Double sampleMinimum,
			Double sampleMaximum) {
		this.unit = unit;
		this.sampleCount = sampleCount;
		this.sampleAverage = sampleAverage;
		this.sampleMinimum = sampleMinimum;
		this.sampleMaximum = sampleMaximum;
	}

	public MeasurementUnit getUnit() {
		return unit;
	}

	public int getSampleCount() {
		return sampleCount;
	}

	public Double getSampleAverage() {
		return sampleAverage;
	}

	public Double getSampleMinimum() {
		return sampleMinimum;
	}

	public Double getSampleMaximum() {
		return sampleMaximum;
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
