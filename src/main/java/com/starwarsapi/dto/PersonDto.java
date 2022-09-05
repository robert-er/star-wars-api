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

    private Long swid;
    private String name;
    private String height;
    private String mass;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return swid.equals(personDto.swid) && name.equals(personDto.name) && height.equals(personDto.height) && mass.equals(personDto.mass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(swid, name, height, mass);
    }
}
