package com.starwarsapi.mapper;

import com.starwarsapi.domain.Person;
import com.starwarsapi.dto.PersonDto;
import com.starwarsapi.utils.PersonTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void shouldMapToPerson() {
        //given
        Person mappedPerson;
        PersonDto personDto = PersonTestUtils.createPersonDto();

        //when
        mappedPerson = personMapper.mapToPerson(personDto);

        //then
        assertEquals(personDto.getSwid(), mappedPerson.getSwid());
        assertEquals(personDto.getName(), mappedPerson.getName());
        assertEquals(personDto.getHeight(), mappedPerson.getHeight());
        assertEquals(personDto.getMass(), mappedPerson.getMass());
    }

    @Test
    public void shouldMapToPersonDto() {
        //given
        PersonDto mappedPersonDto;
        Person person = PersonTestUtils.createPerson();

        //when
        mappedPersonDto = personMapper.mapToPersonDto(person);

        //then
        assertEquals(person.getSwid(), mappedPersonDto.getSwid());
        assertEquals(person.getName(), mappedPersonDto.getName());
        assertEquals(person.getHeight(), mappedPersonDto.getHeight());
        assertEquals(person.getMass(), mappedPersonDto.getMass());
    }
}