package com.starwarsapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long swid;
    private String name;
    private String height;
    private String mass;

    public Person(Long swid, String name, String height, String mass) {
        this.swid = swid;
        this.name = name;
        this.height = height;
        this.mass = mass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return swid.equals(person.swid) && name.equals(person.name) && height.equals(person.height) && mass.equals(person.mass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(swid, name, height, mass);
    }
}
