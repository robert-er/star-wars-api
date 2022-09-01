package com.starwarsapi.service;

import com.starwarsapi.domain.Person;
import com.starwarsapi.exception.NotFoundException;
import com.starwarsapi.exception.NotValidException;
import com.starwarsapi.exception.PersonAlreadyExist;
import com.starwarsapi.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) throws NotValidException, PersonAlreadyExist {
        validatePerson(person);
        if (personRepository.findByName(person.getName()).isEmpty()) {
            return personRepository.save(person);
        } else {
            throw new PersonAlreadyExist(String.format("Person already exists with name: %s", person.getName()));
        }
    }

    @Override
    public Person getPersonById(Long id) throws NotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Star Wars person with id: %s not found", id)));
    }

    @Override
    public Person getPersonByName(String name) throws NotFoundException {
        return personRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(String.format("Star Wars person with name: %s not found", name)));
    }

    @Override
    public Person getPersonByHeight(String height) {
        return new Person();
    }

    private void validatePerson(Person person) throws NotValidException {
        if (person.getSwapiId() == null) {
            throw new NotValidException(String.format("Wrong person id: %s", person.getSwapiId()));
        }
        if (person.getName() == null) {
            throw new NotValidException(String.format("Wrong person name: %s", person.getName()));
        }
        if (person.getHeight() == null) {
            throw new NotValidException(String.format("Wrong person height: %s", person.getHeight()));
        }
        if (person.getMass() == null) {
            throw new NotValidException(String.format("Wrong person mass: %s", person.getMass()));
        }
    }
}
