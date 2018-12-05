package io.egen.api.service;

import java.util.List;

import io.egen.entity.WeatherInfo;

public interface WeatherService {
	
	public WeatherInfo create(WeatherInfo weatherInfo);
	
	public List<WeatherInfo> findAllCities();
	
	public WeatherInfo city(String city);
	
	public int temperature(String city);
	
	public int humidity(String city); 
	
	public WeatherInfo hourlyAvgCity(String city);
	
	public WeatherInfo dailyAvgCity(String city);

}
