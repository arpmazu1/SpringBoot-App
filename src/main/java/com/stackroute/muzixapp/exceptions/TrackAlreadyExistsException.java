package com.stackroute.muzixapp.exceptions;

//exception class TrackAlreadyExists
public class TrackAlreadyExistsException extends Exception {
    private String message;

    public TrackAlreadyExistsException(){}
    public TrackAlreadyExistsException(String message){
        super(message);
        this.message=message;
    }


}
