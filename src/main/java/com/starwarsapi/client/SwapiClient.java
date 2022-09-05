package com.starwarsapi.client;

import com.starwarsapi.config.SwapiClientConfig;
import com.starwarsapi.dto.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Component
public class SwapiClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwapiClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SwapiClientConfig config;

    public PersonDto getPersonFromSwapi(Long id) {
        URI url = getUri(id);

        try {
            PersonDto boardResponse = restTemplate.getForObject(url, PersonDto.class);
            return Optional.ofNullable(boardResponse).orElseGet(PersonDto::new);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new PersonDto();
        }
    }

    private URI getUri(Long id) {
        return UriComponentsBuilder
                .fromHttpUrl(config.getSwapiEndpoint() + id)
                .build()
                .encode()
                .toUri();
    }
}
