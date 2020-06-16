package com.egen.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.*;

@Entity(name = "VEHICLE")
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Vehicle {

	@Id
	@Column(name = "VIN")
	private String vin;

	@Column(name = "MAKE")
	private String make;

	@Column(name = "NODEL")
	private String model;

	@Column(name = "YEAR")
	private int year;

	@Column(name = "RED_LINE_RPM")
	private int redlineRpm;

	@Column(name = "MAX_FUEL_VOLUME")
	private int maxFuelVolume;

	@Column(name = "LAST_SERVICE_DATE")
	private LocalDateTime lastServiceDate;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRedLineRpm() {
		return redlineRpm;
	}

	public void setRedLineRpm(int redlineRpm) {
		this.redlineRpm = redlineRpm;
	}

	public int getMaxFuelVolume() {
		return maxFuelVolume;
	}

	public void setMaxFuelVolume(int maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}

	public LocalDateTime getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(LocalDateTime lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastServiceDate == null) ? 0 : lastServiceDate.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + maxFuelVolume;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + redlineRpm;
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		result = prime * result + year;
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
		Vehicle other = (Vehicle) obj;
		if (lastServiceDate == null) {
			if (other.lastServiceDate != null)
				return false;
		} else if (!lastServiceDate.equals(other.lastServiceDate))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (maxFuelVolume != other.maxFuelVolume)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (redlineRpm != other.redlineRpm)
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", redlineRpm="
				+ redlineRpm + ", maxFuelVolume=" + maxFuelVolume + ", lastServiceDate=" + lastServiceDate + "]";
	}

	public static Vehicle getEmptyInstance() {
		return new Vehicle();
	}

}
