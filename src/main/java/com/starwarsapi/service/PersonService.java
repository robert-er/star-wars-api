package com.starwarsapi.service;

import com.starwarsapi.domain.Person;
import com.starwarsapi.exception.NotFoundException;
import com.starwarsapi.exception.NotValidException;
import com.starwarsapi.exception.PersonAlreadyExist;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    Person createPerson(Person person) throws NotValidException, PersonAlreadyExist;
    Person getPersonById(Long id) throws NotFoundException;
    Person getPersonByName(String name) throws NotFoundException;
    Person getPersonByHeight(String height);
}
