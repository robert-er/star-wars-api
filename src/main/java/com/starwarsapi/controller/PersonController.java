package com.starwarsapi.controller;

import com.starwarsapi.client.SwapiClient;
import com.starwarsapi.dto.PersonDto;
import com.starwarsapi.exception.NotFoundException;
import com.starwarsapi.exception.NotValidException;
import com.starwarsapi.exception.PersonAlreadyExist;
import com.starwarsapi.mapper.PersonMapper;
import com.starwarsapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private SwapiClient swapiClient;

    @GetMapping("/{id}")
    public PersonDto getPersonBySwid(@PathVariable Long id) throws NotFoundException {
        return personMapper.mapToPersonDto(personService.getPersonBySwid(id));
    }

    @GetMapping("/name/{name}")
    public PersonDto getPersonByName(@PathVariable String name) throws NotFoundException {
        return personMapper.mapToPersonDto(personService.getPersonByName(name));
    }

    @GetMapping("/name/sub/{subName}")
    public List<PersonDto> getPersonBySubstringName(@PathVariable String subName) throws SQLException, NotFoundException {
        return personMapper.mapToPersonDtoList(personService.getPersonBySubstringName(subName));
    }

    @GetMapping("/maxheight")
    public List<PersonDto> getPeopleByMaxHeight() throws SQLException, NotFoundException {
        return personMapper.mapToPersonDtoList(personService.getPeopleByMaxHeight());
    }

    @PostMapping("/create/{id}")
    public PersonDto createPerson(@PathVariable Long id) throws NotValidException, PersonAlreadyExist {
        PersonDto personDto = swapiClient.getPersonFromSwapi(id);
        personDto.setSwid(id);

        return personMapper.mapToPersonDto(personService.createPerson(personMapper.mapToPerson(personDto)));
    }

    //test endpoint to create fake db persons
    @PostMapping("/create/fake")
    public PersonDto createFakePerson(@RequestBody PersonDto personDto) throws NotValidException, PersonAlreadyExist {
        return personMapper.mapToPersonDto(personService.createPerson(personMapper.mapToPerson(personDto)));
    }
}
