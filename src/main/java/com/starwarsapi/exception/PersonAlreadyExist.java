package com.starwarsapi.exception;

public class PersonAlreadyExist extends Exception {

    public PersonAlreadyExist(String message) {
        super(message);
    }
}
