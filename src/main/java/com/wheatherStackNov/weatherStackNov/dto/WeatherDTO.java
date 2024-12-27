package com.wheatherStackNov.weatherStackNov.dto;

import com.wheatherStackNov.weatherStackNov.model.WeatherEntity;

public record WeatherDTO(String cityName, String country, Integer temperature) {

   public static WeatherDTO convert(WeatherEntity from)
    {
        return new WeatherDTO(from.getCityName(),from.getCountry(),from.getTemperature());
    }
}
