package com.webatrio.personmanager.exception;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(long personId){
        super(String.format("User witth id: %s is not found", personId));
    }
}
