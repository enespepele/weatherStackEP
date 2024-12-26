package com.wheatherStackNov.weatherStackNov.service;

import com.wheatherStackNov.weatherStackNov.dto.WeatherDTO;
import com.wheatherStackNov.weatherStackNov.repository.WeatherRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    public WeatherDTO getWeatherByCityName(String city) {
        return null;
    }

}
