package com.starwarsapi.mapper;

import com.starwarsapi.domain.Person;
import com.starwarsapi.dto.PersonDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    public Person mapToPerson(PersonDto personDto) {
        return new Person(personDto.getSwid(), personDto.getName(), personDto.getHeight(), personDto.getMass());
    }

    public PersonDto mapToPersonDto(Person person) {
        return PersonDto.builder()
                .swid(person.getSwid())
                .name(person.getName())
                .height(person.getHeight())
                .mass(person.getMass())
                .build();
    }

    public List<PersonDto> mapToPersonDtoList(List<Person> personList) {
        return personList.stream().map(this::mapToPersonDto).collect(Collectors.toList());
    }
}
