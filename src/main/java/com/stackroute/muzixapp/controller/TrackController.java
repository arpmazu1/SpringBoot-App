package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//trackcontroller class
@RestController
@RequestMapping(value="api/v1")
public class TrackController {

    //trackservice object
    private TrackService trackService;
    private ResponseEntity responseEntity;

    //TrackController constructor
    @Autowired
    public TrackController (TrackService trackService){
        this.trackService = trackService;
    }

    //savetrack method
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    //getall track method
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    //deletetrack method
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable int id){
   
       trackService.deleteTrack(id);
        responseEntity= new ResponseEntity<>("Deleted",HttpStatus.OK);
        return  responseEntity;
    }

    //updatetrack method
    @PostMapping("id")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){
       
        try {
            trackService.updateTrack(track);
            responseEntity = new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}

