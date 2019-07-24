package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;

import java.util.List;

// trackservice interface
public interface TrackService {

    Track saveTrack(Track track) throws TrackAlreadyExistsException;

    void deleteTrack(int id);

    List<Track> getAllTracks();

    Track updateTrack(Track track);

    Track getTrackByName(String name) throws TrackNotFoundException;


}
