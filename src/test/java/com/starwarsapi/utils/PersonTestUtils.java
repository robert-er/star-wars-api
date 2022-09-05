package com.starwarsapi.utils;

import com.starwarsapi.domain.Person;
import com.starwarsapi.dto.PersonDto;

public class PersonTestUtils {

    private static final Long SW_ID = 1L;
    private static final String NAME = "Luke Skywalker";
    private static final String HEIGHT = "172";
    private static final String MASS = "77";

    public static Person createPerson() {
        return new Person(SW_ID, NAME, HEIGHT, MASS);
    }

    public static PersonDto createPersonDto() {
        return PersonDto.builder()
                .swid(SW_ID)
                .name(NAME)
                .height(HEIGHT)
                .mass(MASS)
                .build();
    }
}
