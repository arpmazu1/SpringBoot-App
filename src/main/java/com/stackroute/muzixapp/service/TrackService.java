package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;

import java.util.List;

//track service interface
public interface TrackService {

    //methods
    Track saveTrack(Track track);

    Track deleteTrack(int id);

    List<Track> getAllTracks();


    Track updateTrack(Track track);


}
