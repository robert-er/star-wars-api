package com.starwarsapi.repository;

import com.starwarsapi.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    Optional<Person> findById(Long id);

    @Override
    <S extends Person> S save(S person);

    Optional<Person> findByName(String name);

    Optional<Person> findByHeight(String height);
}

