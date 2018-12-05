package io.egen.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="WeatherInfo.findAllCities",query="SELECT w.city FROM WeatherInfo w where w.city=:pCity"),
	@NamedQuery(name="WeatherInfo.findTemperature",query = "SELECT w.temperature FROM WeatherInfo w where w.city=:pCity"),
	@NamedQuery(name="WeatherInfo.findHumidity",query = "SELECT w.humidity FROM WeatherInfo w where w.city=:pCity")
})
public class WeatherInfo {
	
	public WeatherInfo() {
		this.id = UUID.randomUUID().toString();
	}
	
	@Id
	private String id;
	private String city;
	private String description;
	private String humidity;
	private String pressure;
	private String temperature;
	private Wind wind;
	private String degree;
	private String timestamp;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "WeatherInfo [city=" + city + ", description=" + description + ", humidity=" + humidity + ", pressure="
				+ pressure + ", temperature=" + temperature + ", wind=" + wind + ", degree=" + degree + ", timestamp="
				+ timestamp + "]";
	}

	
}
