package com.webatrio.personmanager.handler;

import com.webatrio.personmanager.exception.PersonNotFoundException;
import com.webatrio.personmanager.exception.PersonTooOldException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ResponseExceptionBody> handleUserNotFound(
            PersonNotFoundException ex) {
        return new ResponseEntity<>(new ResponseExceptionBody( "Person not found", 404), HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(PersonTooOldException.class)
    public ResponseEntity<ResponseExceptionBody> handleUserNotFound(
            PersonTooOldException ex) {
        return new ResponseEntity<>(new ResponseExceptionBody( "Age is not accepted", 404), HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseExceptionBody> handleMethodArgumentsNotValid(
            MethodArgumentNotValidException exception
    ){
        return new ResponseEntity<>(new ResponseExceptionBody( "Bad request", 400), HttpStatusCode.valueOf(400));
    }
}
