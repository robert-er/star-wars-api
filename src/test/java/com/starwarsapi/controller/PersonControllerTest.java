package com.starwarsapi.controller;

import com.starwarsapi.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.NestedServletException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetPersonBySwid() throws Exception {
        mockMvc.perform(post("/people/create/7"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/people/{id}", "7"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Beru Whitesun lars"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000"})
    public void shouldReturnNotFoundException(String id) throws Exception {
        assertThrows(NestedServletException.class, () -> {
            mockMvc.perform(get("/people/{id}", id))
                    .andExpect(status().isInternalServerError())
                    .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotFoundException))
                    .andExpect(result -> assertEquals("Star Wars person with SW id: " + id + " not found",
                            Objects.requireNonNull(result.getResolvedException()).getMessage()));
        });
    }

    @Test
    public void shouldGetPersonByName() throws Exception {
        String name = "R5-D4";
        mockMvc.perform(post("/people/create/8"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/people/name/{name}", name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name));
    }

    @Test
    public void shouldGetPersonBySubstringName() throws Exception {
        mockMvc.perform(post("/people/create/6"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/people/name/sub/{subName}", "Owen"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Owen Lars"));
    }

    @Test
    public void shouldGetPeopleByMaxHeight() throws Exception {
        mockMvc.perform(post("/people/create/5"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/people/maxheight"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Leia Organa"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void shouldCreatePerson(String id) throws Exception {
        mockMvc.perform(post("/people/create/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());
    }
}