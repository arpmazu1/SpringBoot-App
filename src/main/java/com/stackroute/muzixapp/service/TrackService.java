package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

// trackservice interface
public interface TrackService {

    Track saveTrack(Track track) throws TrackAlreadyExistsException;

    void deleteTrack(int id);

    List<Track> getAllTracks();

    Track updateTrack(Track track);

    Track getTrackByName(String name) throws TrackNotFoundException;

    void getTopTracks();

}
