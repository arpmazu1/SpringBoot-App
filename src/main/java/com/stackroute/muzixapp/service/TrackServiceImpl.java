package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//trackserviceimplementation class
@Service
public class TrackServiceImpl implements TrackService {

    //object of TrackRepository
    private TrackRepository trackRepository;

    //constructor
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {

        this.trackRepository = trackRepository;
    }

    //implement all the methods
    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track deleteTrack(int id) {
        Optional<Track> track = trackRepository.findById(id);
        if(track.isPresent()) {
            trackRepository.deleteById(id);
            return track.get();
        }
        else {
             return null;
    }

    @Override
    public List<Track> getAllTracks() {

        return trackRepository.findAll();

    }

    @Override
    public Track updateTrack(Track track) {
        Track updateTrack = trackRepository.save(track);
        return updateTrack;
    }
}

