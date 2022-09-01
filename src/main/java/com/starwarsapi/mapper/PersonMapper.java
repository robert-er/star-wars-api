package com.starwarsapi.mapper;

import com.starwarsapi.domain.Person;
import com.starwarsapi.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person mapToPerson(PersonDto personDto) {
        return Person.builder()
                .swapiId(personDto.getSwapiId())
                .name(personDto.getName())
                .height(personDto.getHeight())
                .mass(personDto.getMass())
                .build();
    }

    public PersonDto mapToPersonDto(Person person) {
        return PersonDto.builder()
                .swapiId(person.getSwapiId())
                .name(person.getName())
                .height(person.getHeight())
                .mass(person.getMass())
                .build();
    }
}
