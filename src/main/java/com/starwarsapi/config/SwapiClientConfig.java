package com.starwarsapi.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SwapiClientConfig {

    @Value("${swapi.endpoint}")
    private String swapiEndpoint;
}
