package com.starwarsapi.utils;

import com.starwarsapi.domain.Person;
import com.starwarsapi.dto.PersonDto;

import java.util.ArrayList;
import java.util.List;

public class PersonTestUtils {

    private static final Long SW_ID = 13L;
    private static final String NAME = "Chewbacca";
    private static final String HEIGHT = "228";
    private static final String MASS = "112";

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

    public static List<Person> createPersonList() {
        List<Person> personList = new ArrayList<>();
        personList.add(createPerson());
        personList.add(new Person(14L, "Han Solo", "180", "80"));
        personList.add(new Person(15L, "Greedo", "173", "74"));
        return personList;
    }
}
