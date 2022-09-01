package com.starwarsapi.service;

import com.starwarsapi.domain.Person;

public interface PersonService {

    Person createPerson(Person person);
    Person getPersonById(Long id);
    Person getPersonByName(String name);
    Person getPersonByHeight(String height);
}
