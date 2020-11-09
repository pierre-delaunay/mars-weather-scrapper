package com.nasa.api.scrapper.model;

import java.util.List;
import java.util.Map;

/**
 * Weather Model
 * 
 * @author Pierre
 *
 */
public class Weather {

	private Map<Integer, Sol> sols;
	private List<Integer> solKeys;

	public Weather(Map<Integer, Sol> sols, List<Integer> solKeys) {
		this.setSols(sols);
		this.setSolKeys(solKeys);
	}

	/**
	 * @return the sols
	 */
	public Map<Integer, Sol> getSols() {
		return sols;
	}

	/**
	 * @param sols the sols to set
	 */
	public void setSols(Map<Integer, Sol> sols) {
		this.sols = sols;
	}

	/**
	 * @return the solKeys
	 */
	public List<Integer> getSolKeys() {
		return solKeys;
	}

	/**
	 * @param solKeys the solKeys to set
	 */
	public void setSolKeys(List<Integer> solKeys) {
		this.solKeys = solKeys;
	}

	@Override
	public String toString() {
		return "Weather [sols=" + sols + ", solKeys=" + solKeys + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((solKeys == null) ? 0 : solKeys.hashCode());
		result = prime * result + ((sols == null) ? 0 : sols.hashCode());
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
		Weather other = (Weather) obj;
		if (solKeys == null) {
			if (other.solKeys != null)
				return false;
		} else if (!solKeys.equals(other.solKeys))
			return false;
		if (sols == null) {
			if (other.sols != null)
				return false;
		} else if (!sols.equals(other.sols))
			return false;
		return true;
	}

}
