package io.egen.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.service.WeatherService;
import io.egen.entity.WeatherInfo;

@RestController
@RequestMapping(value = "/api")
public class WeatherController {
	

	private WeatherService service;
	
	public WeatherController(WeatherService service) {
		this.service = service;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="data")
	public WeatherInfo create(@RequestBody WeatherInfo weatherInfo) {
		System.out.println("post method");
		return service.create(weatherInfo);	
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "cities")
	public List<WeatherInfo> findAllCities(){
		return service.findAllCities();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "{city}")
	public WeatherInfo city(@PathVariable("city") String city) {
		return service.city(city);		
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "temperature/{city}")
	public int temperature(@PathVariable("city") String city) {
		return service.temperature(city);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "humidity/{city}")
	public int humidity(@PathVariable("city") String city) {
		return service.humidity(city);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "hourly/{city}")
	public WeatherInfo hourlyAvgCity(@PathVariable("city") String city) {
		return service.hourlyAvgCity(city);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "daily/{city}")
	public WeatherInfo dailyAvgCity(@PathVariable("city") String city) {
		return service.dailyAvgCity(city);
	}

}
