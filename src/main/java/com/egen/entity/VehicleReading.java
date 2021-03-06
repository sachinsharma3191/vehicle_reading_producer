package com.egen.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.*;

@Entity(name = "VEHICLE_READING")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@NoArgsConstructor
@AllArgsConstructor
public class VehicleReading {
	@Id
	@Column
	private String vin;

	@Column
	private float latitude;

	@Column
	private float longitude;

	@Column
	private LocalDateTime timestamp;

	@Column
	private float fuelVolume;

	@Column
	private float speed;

	@Column
	private float engineHp;

	@Column
	private boolean checkEngineLightOn;

	@Column
	private boolean engineCoolantLow;

	@Column
	private boolean cruiseControlOn;

	@Column(name = "ENGINE_RPM")
	private float engineRpm;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinTable(name = "VEHICLE_TYRE_READING", joinColumns = @JoinColumn(name = "VIN"), inverseJoinColumns = @JoinColumn(name = "ID"))
	Tires tires;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (checkEngineLightOn ? 1231 : 1237);
		result = prime * result + (cruiseControlOn ? 1231 : 1237);
		result = prime * result + (engineCoolantLow ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(engineHp);
		result = prime * result + Float.floatToIntBits(engineRpm);
		result = prime * result + Float.floatToIntBits(fuelVolume);
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + Float.floatToIntBits(speed);
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((tires == null) ? 0 : tires.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		return result;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public float getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(float fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getEngineHp() {
		return engineHp;
	}

	public void setEngineHp(float engineHp) {
		this.engineHp = engineHp;
	}

	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}

	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}

	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}

	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}

	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}

	public float getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(float engineRpm) {
		this.engineRpm = engineRpm;
	}

	public Tires getTires() {
		return tires;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleReading other = (VehicleReading) obj;
		if (checkEngineLightOn != other.checkEngineLightOn)
			return false;
		if (cruiseControlOn != other.cruiseControlOn)
			return false;
		if (engineCoolantLow != other.engineCoolantLow)
			return false;
		if (Float.floatToIntBits(engineHp) != Float.floatToIntBits(other.engineHp))
			return false;
		if (Float.floatToIntBits(engineRpm) != Float.floatToIntBits(other.engineRpm))
			return false;
		if (Float.floatToIntBits(fuelVolume) != Float.floatToIntBits(other.fuelVolume))
			return false;
		if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
			return false;
		if (Float.floatToIntBits(speed) != Float.floatToIntBits(other.speed))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (tires == null) {
			if (other.tires != null)
				return false;
		} else if (!tires.equals(other.tires))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}

}
