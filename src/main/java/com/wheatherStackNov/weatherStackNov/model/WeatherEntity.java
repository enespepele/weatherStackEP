package com.wheatherStackNov.weatherStackNov.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
public class WeatherEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String requestedCityName;
    private String cityName;
    private String country;
    private Integer temperature;
    private LocalDateTime updatedTime;
    private LocalDateTime responseLocalTime;
    public WeatherEntity(String id, String requestedCityName, String cityName, String country, Integer temperature, LocalDateTime updateTime, LocalDateTime responseLocalTime) {
        this.id = id;
        this.requestedCityName = requestedCityName;
        this.cityName = cityName;
        this.country = country;
        this.temperature = temperature;
        this.updatedTime = updateTime;
        this.responseLocalTime = responseLocalTime;
    }

    public WeatherEntity(String cityName, Integer temperature, LocalDateTime responseLocalTime, String requestedCityName, String country, LocalDateTime updateTime) {

        this.cityName = cityName;
        this.temperature = temperature;
        this.responseLocalTime = responseLocalTime;
        this.requestedCityName = requestedCityName;
        this.country = country;
        this.updatedTime = updateTime;
    }
    public WeatherEntity(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRequestedCityName() {
        return requestedCityName;
    }

    public void setRequestedCityName(String requestedCityName) {
        this.requestedCityName = requestedCityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getUpdateTime() {
        return updatedTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updatedTime = updateTime;
    }

    public LocalDateTime getResponseLocalTime() {
        return responseLocalTime;
    }

    public void setResponseLocalTime(LocalDateTime responseLocalTime) {
        this.responseLocalTime = responseLocalTime;
    }
}
