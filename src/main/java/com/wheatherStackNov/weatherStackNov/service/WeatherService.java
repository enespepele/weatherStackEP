package com.wheatherStackNov.weatherStackNov.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wheatherStackNov.weatherStackNov.dto.WeatherDTO;
import com.wheatherStackNov.weatherStackNov.dto.WeatherResponse;
import com.wheatherStackNov.weatherStackNov.model.WeatherEntity;
import com.wheatherStackNov.weatherStackNov.repository.WeatherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class WeatherService {
    private static final String API_URL ="http://api.weatherstack.com/current?access_key=ee204aa4c6c4c35c8e452a983ad1451b&query=";

    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper=new ObjectMapper();
//http://api.weatherstack.com/current?access_key=ee204aa4c6c4c35c8e452a983ad1451b&query=Malatya
    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    public WeatherDTO getWeatherByCityName(String city) {

        Optional<WeatherEntity> weatherEntityOptional = weatherRepository.findFirstByRequestedCityNameOrderByUpdatedTimeDesc(city);
        if(!weatherEntityOptional.isPresent()){
            return WeatherDTO.convert(getWeatherFromWeatherStack(city));
        }

        return WeatherDTO.convert(weatherEntityOptional.get());
    }
    private WeatherEntity getWeatherFromWeatherStack(String city){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(API_URL+city,String.class);
        try {
            WeatherResponse weatherResponse = objectMapper.readValue(responseEntity.getBody(),WeatherResponse.class);
            return saveWeatherEntity(city,weatherResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    private WeatherEntity saveWeatherEntity(String city,WeatherResponse weatherResponse){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        WeatherEntity weatherEntity = new WeatherEntity(weatherResponse.location().name(),
                weatherResponse.current().temperature(),
                LocalDateTime.now(),
                city,
                weatherResponse.location().country(),
                LocalDateTime.parse(weatherResponse.location().localtime(),dateTimeFormatter));


        return weatherRepository.save(weatherEntity);
    }
}
