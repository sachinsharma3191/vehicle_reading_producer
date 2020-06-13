package com.egen.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "VEHICLE")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "VIN")
	private String vin;

	@Column(name = "MAKE")
	private String make;

	@Column(name = "NODEL")
	private String model;

	@Column(name = "YEAR")
	private int year;

	@Column(name = "RED_LINE_RPM")
	private int redLineRpm;

	@Column(name = "MAX_FUEL_VOLUME")
	private int maxFuelVolume;

	@Column(name = "LAST_SERVICE_DATE")
	private LocalDateTime lastServiceDate;

	public Vehicle() {
		super();
	}

	public Vehicle(Long id, String vin, String make, String model, int year, int redLineRpm, int maxFuelVolume,
			LocalDateTime lastServiceDate) {
		super();
		this.id = id;
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.redLineRpm = redLineRpm;
		this.maxFuelVolume = maxFuelVolume;
		this.lastServiceDate = lastServiceDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return redLineRpm;
	}

	public void setRedLineRpm(int redLineRpm) {
		this.redLineRpm = redLineRpm;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastServiceDate == null) ? 0 : lastServiceDate.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + maxFuelVolume;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + redLineRpm;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
		if (redLineRpm != other.redLineRpm)
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
		return "Vehicle [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", redLineRpm="
				+ redLineRpm + ", maxFuelVolume=" + maxFuelVolume + ", lastServiceDate=" + lastServiceDate + "]";
	}

}
