package com.wheatherStackNov.weatherStackNov.dto;

public record Request(String type,
                      String query,
                      String language,
                      String unit) {
}
