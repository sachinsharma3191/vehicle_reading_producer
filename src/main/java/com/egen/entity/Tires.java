package com.egen.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.*;

@Entity(name = "TYRE_PRESSURE")
@Setter
@Getter
@AllArgsConstructor
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(frontLeft);
		result = prime * result + Float.floatToIntBits(frontRight);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(rearLeft) != Float.floatToIntBits(other.rearLeft))
			return false;
		if (Float.floatToIntBits(rearRight) != Float.floatToIntBits(other.rearRight))
			return false;
		return true;
	}

}
