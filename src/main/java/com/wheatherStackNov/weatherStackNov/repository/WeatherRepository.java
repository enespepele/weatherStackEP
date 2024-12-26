package com.wheatherStackNov.weatherStackNov.repository;

import com.wheatherStackNov.weatherStackNov.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherEntity,String> {
}
