package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;

import java.util.List;

// trackservice interface
public interface TrackService {

    Track saveTrack(Track track);

    void deleteTrack(int id);

    List<Track> getAllTracks();

    Track updateTrack(Track track);

    Track getTrackByName(String name);


}
