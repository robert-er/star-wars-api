package com.starwarsapi.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long swapiId;

    private String name;
    private int height;
    private int mass;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return height == person.height && mass == person.mass && swapiId.equals(person.swapiId) && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(swapiId, name, height, mass);
    }
}
