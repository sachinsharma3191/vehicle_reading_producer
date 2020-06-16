package com.egen.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleAlert {

	private String priority;
	private String vin;

	public VehicleAlert(VehicleAlertBuilder builder) {
		this.vin = builder.vin;
		this.priority = builder.priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
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
		VehicleAlert other = (VehicleAlert) obj;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}

	public final static VehicleAlertBuilder builder() {
		return new VehicleAlertBuilder();
	}

	public static final class VehicleAlertBuilder {
		private String priority;
		private String vin;

		public VehicleAlertBuilder vin(String vin) {
			this.vin = vin;
			return this;
		}

		public VehicleAlertBuilder priority(String priority) {
			this.priority = priority;
			return this;
		}

		public VehicleAlert build() {
			return new VehicleAlert(this);
		}
	}
}
