package com.egen.model;

import java.time.LocalDateTime;

public class Weather {
	private String city;
	private String decription;
	private int humidity;
	private int pressure;
	private double temperature;
	private Wind wind;
	private LocalDateTime timestamp;

	public Weather() {
		super();
	}

	public Weather(String city, String decription, int humidity, int pressure, double temperature, Wind wind,
			LocalDateTime timestamp) {
		super();
		this.city = city;
		this.decription = decription;
		this.humidity = humidity;
		this.pressure = pressure;
		this.temperature = temperature;
		this.wind = wind;
		this.timestamp = timestamp;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public int gethumidity() {
		return humidity;
	}

	public void sethumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((decription == null) ? 0 : decription.hashCode());
		result = prime * result + humidity;
		result = prime * result + pressure;
		long temp;
		temp = Double.doubleToLongBits(temperature);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((wind == null) ? 0 : wind.hashCode());
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
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (decription == null) {
			if (other.decription != null)
				return false;
		} else if (!decription.equals(other.decription))
			return false;
		if (humidity != other.humidity)
			return false;
		if (pressure != other.pressure)
			return false;
		if (Double.doubleToLongBits(temperature) != Double.doubleToLongBits(other.temperature))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (wind == null) {
			if (other.wind != null)
				return false;
		} else if (!wind.equals(other.wind))
			return false;
		return true;
	}

}
