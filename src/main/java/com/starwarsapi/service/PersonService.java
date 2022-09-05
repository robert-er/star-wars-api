package com.starwarsapi.service;

import com.starwarsapi.domain.Person;
import com.starwarsapi.exception.NotFoundException;
import com.starwarsapi.exception.NotValidException;
import com.starwarsapi.exception.PersonAlreadyExist;

import java.sql.SQLException;
import java.util.List;

public interface PersonService {

    Person createPerson(Person person) throws NotValidException, PersonAlreadyExist;
    Person getPersonBySwid(Long swid) throws NotFoundException;
    Person getPersonByName(String name) throws NotFoundException;
    List<Person> getPersonBySubstringName(String sub) throws SQLException, NotFoundException;
    List<Person> getPeopleByMaxHeight() throws SQLException, NotFoundException;
    void deleteByName(String name);
}
