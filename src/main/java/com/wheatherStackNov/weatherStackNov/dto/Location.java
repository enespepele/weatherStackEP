package com.wheatherStackNov.weatherStackNov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(String name, String country,
                       @JsonProperty("localtime")
                       String localtime) {
}
