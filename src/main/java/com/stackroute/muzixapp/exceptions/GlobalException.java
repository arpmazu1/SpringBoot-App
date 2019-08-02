package com.stackroute.muzixapp.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    //This method handles the custom exception class TrackAlreadyExistsException
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity<String> playerExistsHandler(TrackAlreadyExistsException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    //This method handles the custom exception class TrackNotFoundException
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<String> playerNotFoundHandler(TrackNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
    }
}

