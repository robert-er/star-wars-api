package com.starwarsapi.service;

import com.starwarsapi.domain.Person;
import com.starwarsapi.exception.NotFoundException;
import com.starwarsapi.exception.NotValidException;
import com.starwarsapi.exception.PersonAlreadyExist;
import com.starwarsapi.utils.PersonTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonServiceImplTest {

    @Autowired
    private PersonService personService;

   @Test
    public void shouldCreatePerson() throws NotValidException, PersonAlreadyExist {
        //given
        Person person = PersonTestUtils.createPerson();
        //when
        Person createdPerson = personService.createPerson(person);
        //then
        assertEquals(person.getSwid(), createdPerson.getSwid());
        assertEquals(person.getName(), createdPerson.getName());
        assertEquals(person.getHeight(), createdPerson.getHeight());
        assertEquals(person.getMass(), createdPerson.getMass());
        //cleanUp
       personService.deleteByName(person.getName());
    }

    @Test
    public void shouldGetPersonById() throws NotValidException, PersonAlreadyExist, NotFoundException {
        //given
        Person person = PersonTestUtils.createPerson();
        personService.createPerson(person);
        //when
        Person returnedPerson = personService.getPersonBySwid(person.getSwid());
        //then
        assertEquals(person.getSwid(), returnedPerson.getSwid());
        assertEquals(person.getName(), returnedPerson.getName());
        assertEquals(person.getHeight(), returnedPerson.getHeight());
        assertEquals(person.getMass(), returnedPerson.getMass());
        //cleanUp
        personService.deleteByName(person.getName());
    }

    @Test
    public void shouldGetPersonByName() throws NotValidException, PersonAlreadyExist, NotFoundException {
        //given
        Person person = PersonTestUtils.createPerson();
        personService.createPerson(person);
        //when
        Person returnedPerson = personService.getPersonByName(person.getName());
        //then
        assertEquals(person.getSwid(), returnedPerson.getSwid());
        assertEquals(person.getName(), returnedPerson.getName());
        assertEquals(person.getHeight(), returnedPerson.getHeight());
        assertEquals(person.getMass(), returnedPerson.getMass());
        //cleanUp
        personService.deleteByName(person.getName());
    }

    @Test
    public void shouldGetPersonBySubstringName() throws NotValidException, PersonAlreadyExist, SQLException, NotFoundException {
        //given
        Person person = PersonTestUtils.createPerson();
        personService.createPerson(person);
        String subName = person.getName().substring(0,2);
        //when
        Person returnedPerson = personService.getPersonBySubstringName(subName).stream().findFirst()
                .orElseThrow(() -> new NotFoundException("PersonServiceImplTest: shouldGetPersonBySubstringName. 0 people found"));
        //then
        assertEquals(person.getSwid(), returnedPerson.getSwid());
        assertEquals(person.getName(), returnedPerson.getName());
        assertEquals(person.getHeight(), returnedPerson.getHeight());
        assertEquals(person.getMass(), returnedPerson.getMass());
        //cleanUp
        personService.deleteByName(person.getName());
    }
}