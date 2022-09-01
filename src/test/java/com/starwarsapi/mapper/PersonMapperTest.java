package com.starwarsapi.mapper;

import com.starwarsapi.domain.Person;
import com.starwarsapi.dto.PersonDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PersonMapper.class})
class PersonMapperTest {

    private static final Long SWAPI_ID = 1L;
    private static final String NAME = "Luke Skywalker";
    private static final String HEIGHT = "172";
    private static final String MASS = "77";

    private final Person luke = Person.builder()
            .swapiId(SWAPI_ID)
            .name(NAME)
            .height(HEIGHT)
            .mass(MASS)
            .build();

    private final PersonDto lukeDto = PersonDto.builder()
            .swapiId(SWAPI_ID)
            .name(NAME)
            .height(HEIGHT)
            .mass(MASS)
            .build();

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void mapToPerson() {
        //given
        Person mappedPerson;

        //when
        mappedPerson = personMapper.mapToPerson(lukeDto);

        //then
        assertEquals(lukeDto.getSwapiId(), mappedPerson.getSwapiId());
        assertEquals(lukeDto.getName(), mappedPerson.getName());
        assertEquals(lukeDto.getHeight(), mappedPerson.getHeight());
        assertEquals(lukeDto.getMass(), mappedPerson.getMass());
    }

    @Test
    public void mapToPersonDto() {
        //given
        PersonDto mappedPersonDto;

        //when
        mappedPersonDto = personMapper.mapToPersonDto(luke);

        //then
        assertEquals(luke.getSwapiId(), mappedPersonDto.getSwapiId());
        assertEquals(luke.getName(), mappedPersonDto.getName());
        assertEquals(luke.getHeight(), mappedPersonDto.getHeight());
        assertEquals(luke.getMass(), mappedPersonDto.getMass());
    }
}