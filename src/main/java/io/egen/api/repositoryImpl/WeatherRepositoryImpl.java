package io.egen.api.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.api.repository.WeatherRepository;
import io.egen.entity.WeatherInfo;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public WeatherInfo create(WeatherInfo weatherInfo) {
		em.persist(weatherInfo);
		return weatherInfo;
		
	}

	@Override
	public List<WeatherInfo> findAllCities() {
		TypedQuery<WeatherInfo> query = em.createNamedQuery("WeatherInfo.findAllCities", WeatherInfo.class);
		List<WeatherInfo> cities = query.getResultList();
		return cities;
	}

	@Override
	public WeatherInfo city(String city) {
		return em.find(WeatherInfo.class, city);
	}

	@Override
	public int temperature(String city) {
		return 0;
	}

	@Override
	public int humidity(String city) {
		return 0;
	}

	@Override
	public WeatherInfo hourlyAvgCity(String city) {
		return null;
	}

	@Override
	public WeatherInfo dailyAvgCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
