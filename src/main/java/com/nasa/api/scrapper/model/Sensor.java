package com.nasa.api.scrapper.model;

import java.util.HashMap;
import java.util.Map;

/**
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
}
