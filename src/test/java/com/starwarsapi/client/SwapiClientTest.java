package com.starwarsapi.client;

import com.starwarsapi.dto.PersonDto;
import com.starwarsapi.utils.PersonTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SwapiClientTest {

    @Autowired
    private SwapiClient swapiClient;

    @Test
    public void getPersonFromSwapi() {
        //given
        PersonDto localPersonDto = PersonTestUtils.createPersonDto();
        Long swid = localPersonDto.getSwid();
        //when
        PersonDto SwapiPersonDto = swapiClient.getPersonFromSwapi(swid);
        //then
        assertEquals(localPersonDto.getSwid(), SwapiPersonDto.getSwid());
        assertEquals(localPersonDto.getName(), SwapiPersonDto.getName());
        assertEquals(localPersonDto.getHeight(), SwapiPersonDto.getHeight());
        assertEquals(localPersonDto.getMass(), SwapiPersonDto.getMass());
    }
}