package com.starwarsapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PersonServiceImpl.class})
public class PersonServiceImplTest {

    @Autowired
    private PersonService personService;

 //  @Test
//    public void shouldCreatePerson() throws NotValidException, PersonAlreadyExist {
//        //given
//        Person person = PersonTestUtils.createPerson();
//        //when
//        Person createdPerson = personService.createPerson(person);
//        //then
//        assertEquals(person.getSwapiId(), createdPerson.getSwapiId());
//        assertEquals(person.getName(), createdPerson.getName());
//        assertEquals(person.getHeight(), createdPerson.getHeight());
//        assertEquals(person.getMass(), createdPerson.getMass());
//    }

 //   @Test
    public void shouldGetPersonById() {
    }

 //   @Test
    public void shouldGetPersonByName() {
    }

 //   @Test
    public void shouldGetPersonByHeight() {
    }
}