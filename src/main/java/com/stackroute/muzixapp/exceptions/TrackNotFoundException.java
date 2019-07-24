package com.stackroute.muzixapp.exceptions;

//exception class TrackNotFound
public class TrackNotFoundException extends Exception {
    private String message;

    public TrackNotFoundException(){}
    public TrackNotFoundException(String message){
        super(message);
        this.message=message;
    }
}
