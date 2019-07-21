package com.canx.restapp.controller;

import com.canx.restapp.client.openweather.OpenWeatherClient;
import com.canx.restapp.client.openweather.WeatherInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/weather", produces = "application/json")
public class WeatherController {

    private final OpenWeatherClient openWeatherClient;

    public WeatherController(OpenWeatherClient openWeatherClient) {
        this.openWeatherClient = openWeatherClient;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    WeatherInfo getCurrentWeather(@RequestParam String city, @RequestParam String country) {
        return openWeatherClient.getCurrentWeatherInfo(city, country);
    }


}
