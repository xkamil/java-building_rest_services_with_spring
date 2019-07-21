package com.canx.restapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class RestConfiguration {

    @Value("${restConnection.readTimeout}")
    private long connectionTimeout;

    @Value("${restConnection.connectionTimeout}")
    private long readTimeout;

    private final LoggingRequestInterceptor loggingRequestInterceptor;

    public RestConfiguration(LoggingRequestInterceptor loggingRequestInterceptor) {
        this.loggingRequestInterceptor = loggingRequestInterceptor;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .requestFactory(()-> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .setConnectTimeout(Duration.of(connectionTimeout, ChronoUnit.MILLIS))
                .setReadTimeout(Duration.of(readTimeout, ChronoUnit.MILLIS))
                .interceptors(loggingRequestInterceptor)
                .build();
    }
}
