package com.wheatherStackNov.weatherStackNov.repository;

import com.wheatherStackNov.weatherStackNov.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherEntity,String> {

//    findFirstByRequestedCityOrderedByUpdatedTimeDesc(String city)

    Optional<WeatherEntity> findFirstByRequestedCityNameOrderByUpdatedTimeDesc(String city);
   // List<WeatherEntity>     findAllByRequestedCityNameOrderedByUpdatedTimeDesc(String city);

}
