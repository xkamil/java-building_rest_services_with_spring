package com.canx.restapp.client.openweather;

public interface OpenWeatherClient {

    WeatherInfo getCurrentWeatherInfo(String city, String country);
}
