package com.wheatherStackNov.weatherStackNov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherStackNovApplication {
	private static final Logger logger = LoggerFactory.getLogger(WeatherStackNovApplication.class);
	public static void main(String[] args) {
		logger.info("App is started");

		SpringApplication.run(WeatherStackNovApplication.class, args);
		//2 24 36 da kaldık

	}

}
