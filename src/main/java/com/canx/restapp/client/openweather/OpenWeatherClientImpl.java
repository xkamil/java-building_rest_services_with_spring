package com.canx.restapp.client.openweather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class OpenWeatherClientImpl implements OpenWeatherClient {

    @Value("${restConnection.openweather.url}")
    private String url;

    @Value("${restConnection.openweather.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public OpenWeatherClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    @Override
    public WeatherInfo getCurrentWeatherInfo(String city, String country) {
        URI uri = URI.create(url + city + "," + country);
        RequestEntity<Void> entity = RequestEntity
                .get(uri)
                .header("X-RapidAPI-Key", apiKey)
                .build();
        return restTemplate.exchange(entity, WeatherInfo.class).getBody();
    }

}
