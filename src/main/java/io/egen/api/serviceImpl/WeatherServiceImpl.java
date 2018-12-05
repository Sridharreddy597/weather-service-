package io.egen.api.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.exception.NotFoundException;
import io.egen.api.repository.WeatherRepository;
import io.egen.api.service.WeatherService;
import io.egen.entity.WeatherInfo;

@Service
public class WeatherServiceImpl implements WeatherService{
	

	private WeatherRepository repository;
	
	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public WeatherInfo create(WeatherInfo weatherInfo) {
		System.out.println(weatherInfo.toString());
		return repository.create(weatherInfo);
	}

	@Override
	public List<WeatherInfo> findAllCities() {
		return repository.findAllCities();
	}

	@Override
	public WeatherInfo city(String city) {
		WeatherInfo weather = repository.city(city);
		if (weather == null) {
			throw new NotFoundException("City with name " + city + ", does not exist");		
		}
		return weather;
	}

	@Override
	public int temperature(String city) {
		int temp = repository.temperature(city);
		if (temp == 0) {
			throw new NotFoundException("City with name " + city + ", does not exist");			
		}
		return temp;
	}

	@Override
	public int humidity(String city) {
		int humidity = repository.humidity(city);
		if (humidity == 0) {
			throw new NotFoundException("City with name " + city + ", does not exist");
		}
		return humidity;
	}

	@Override
	public WeatherInfo hourlyAvgCity(String city) {
		WeatherInfo weather = repository.hourlyAvgCity(city);
		if (weather == null) {
			throw new NotFoundException("City with name " + city + ", does not exist");
		}
		return weather;
	}

	@Override
	public WeatherInfo dailyAvgCity(String city) {
		WeatherInfo weather = repository.dailyAvgCity(city);
		if (weather == null) {
			throw new NotFoundException("City with name " + city + ", does not exist");
		}
		return weather;
	}

}
