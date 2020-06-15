package com.egen.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity(name = "TYRE_PRESSURE")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Tires {

	@Id
	private String id;

	@Column
	private float frontLeft;
	
	@Column
	private float frontRight;
	
	@Column
	private float rearLeft;
	
	@Column
	private float rearRight;

	public Tires() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	public Tires(String id, float frontLeft, float frontRight, float rearLeft, float rearRight) {
		super();
		this.id = id;
		this.frontLeft = frontLeft;
		this.frontRight = frontRight;
		this.rearLeft = rearLeft;
		this.rearRight = rearRight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getFrontLeft() {
		return frontLeft;
	}

	public float getFrontRight() {
		return frontRight;
	}

	public float getRearLeft() {
		return rearLeft;
	}

	public float getRearRight() {
		return rearRight;
	}

	// Setter Methods

	public void setFrontLeft(float frontLeft) {
		this.frontLeft = frontLeft;
	}

	public void setFrontRight(float frontRight) {
		this.frontRight = frontRight;
	}

	public void setRearLeft(float rearLeft) {
		this.rearLeft = rearLeft;
	}

	public void setRearRight(float rearRight) {
		this.rearRight = rearRight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(frontLeft);
		result = prime * result + Float.floatToIntBits(frontRight);
		result = prime * result + Float.floatToIntBits(rearLeft);
		result = prime * result + Float.floatToIntBits(rearRight);
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
		Tires other = (Tires) obj;
		if (Float.floatToIntBits(frontLeft) != Float.floatToIntBits(other.frontLeft))
			return false;
		if (Float.floatToIntBits(frontRight) != Float.floatToIntBits(other.frontRight))
			return false;
		if (Float.floatToIntBits(rearLeft) != Float.floatToIntBits(other.rearLeft))
			return false;
		if (Float.floatToIntBits(rearRight) != Float.floatToIntBits(other.rearRight))
			return false;
		return true;
	}

}
