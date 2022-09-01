package com.starwarsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {

    private Long swapiId;
    private String name;
    private int height;
    private int mass;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return height == personDto.height && mass == personDto.mass && swapiId.equals(personDto.swapiId) && name.equals(personDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(swapiId, name, height, mass);
    }
}
