package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
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

    //implementing all the methods
    //throws Exception TrackAlreadyExists
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
            Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public void deleteTrack(int id) {

        trackRepository.deleteById(id);

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

    //throws exception TrackNotFoundException
    @Override
    public Track getTrackByName(String name) throws TrackNotFoundException {
        if(trackRepository.findTrackByName(name)==null){
            throw new TrackNotFoundException("Track not found");

        }
        return trackRepository.findTrackByName(name);
    }
}

