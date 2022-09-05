package com.starwarsapi.service;

import com.starwarsapi.domain.Person;
import com.starwarsapi.exception.NotFoundException;
import com.starwarsapi.exception.NotValidException;
import com.starwarsapi.exception.PersonAlreadyExist;

import java.sql.SQLException;
import java.util.List;

public interface PersonService {

    Person createPerson(Person person) throws NotValidException, PersonAlreadyExist;
    Person getPersonBySwid(Long id) throws NotFoundException;
    Person getPersonByName(String name) throws NotFoundException;
    List<Person> getPersonBySubstringName(String sub) throws SQLException, NotFoundException;
    Person getPersonByHeight(String height) throws NotFoundException;
    List<Person> getPeopleByMaxHeight() throws SQLException, NotFoundException;
}
