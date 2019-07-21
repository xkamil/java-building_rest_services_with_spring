package com.canx.restapp.client.openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class WeatherInfo {
    private Main main;

    @Data
    public static class Main {
        private BigDecimal temp;
        private BigDecimal pressure;
        private BigDecimal humidity;
        private BigDecimal temp_min;
        private BigDecimal temp_max;
    }
}
