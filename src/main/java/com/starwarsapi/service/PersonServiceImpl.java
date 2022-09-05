package com.starwarsapi.service;

import com.starwarsapi.config.DbConfig;
import com.starwarsapi.domain.Person;
import com.starwarsapi.exception.NotFoundException;
import com.starwarsapi.exception.NotValidException;
import com.starwarsapi.exception.PersonAlreadyExist;
import com.starwarsapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DbConfig dbConfig;

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
    public Person getPersonBySwid(Long swid) throws NotFoundException {
        return personRepository.findBySwid(swid)
                .orElseThrow(() -> new NotFoundException(String.format("Star Wars person with SW id: %s not found", swid)));
    }

    @Override
    public Person getPersonByName(String name) throws NotFoundException {
        return personRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(String.format("Star Wars person with name: %s not found", name)));
    }

    @Override
    public List<Person> getPersonBySubstringName(String sub) throws SQLException, NotFoundException {
        String query = "SELECT name FROM person WHERE name LIKE _";
        query = query.replaceFirst("[_]", "'%" + sub + "%'");

        return getPeople(query);
    }

    @Override
    public List<Person> getPeopleByMaxHeight() throws SQLException, NotFoundException {
        String query = "SELECT name FROM person WHERE height < _";
        query = query.replaceFirst("[_]", dbConfig.getMaxHeight());

        return getPeople(query);
    }

    public void deleteByName(String name) {
        personRepository.deleteByName(name);
    }

    private List<Person> getPeople(String query) throws SQLException, NotFoundException {
        List<Person> result = new ArrayList<>();
        Connection con = DriverManager.getConnection(dbConfig.getDbUrl(), dbConfig.getDbUsername(), dbConfig.getDbPassword());

        PreparedStatement getPeople = con.prepareStatement(query);
        ResultSet resultSet = getPeople.executeQuery();

        while (resultSet.next()) {
            result.add(getPersonByName(resultSet.getString("name")));
        }
        return result;
    }

    private void validatePerson(Person person) throws NotValidException {
        if (person.getSwid() == null) {
            throw new NotValidException(String.format("Wrong person SW id: %s", person.getSwid()));
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
