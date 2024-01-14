package com.webatrio.personmanager.exception;

public class PersonTooOldException extends RuntimeException{

    public PersonTooOldException(){
        super("person is too old, max age is 150");
    }
}
