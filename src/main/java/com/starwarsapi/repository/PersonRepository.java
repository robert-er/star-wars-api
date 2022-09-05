package com.starwarsapi.repository;

import com.starwarsapi.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    Optional<Person> findById(Long id);

    @Override
    <S extends Person> S save(S person);

    Optional<Person> findBySwid(Long id);

    Optional<Person> findByName(String name);

    void deleteByName(String name);
}

