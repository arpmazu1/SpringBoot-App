package com.stackroute.muzixapp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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

    @Override
    public void getTopTracks(){
        //fetching the data form last fm
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=27036d1beeac4bd17a15753129f97d61&format=json";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        //an object of object mapper
        ObjectMapper mapper = new ObjectMapper();
        //jsonnode object
        JsonNode node = null;
        try {

            node = mapper.readTree(response.getBody());

            //storing the data in array and fetching the data which is required
            ArrayNode arraynode = (ArrayNode) node.path("tracks").path("track");

            for (int i = 0; i < arraynode.size(); i++) {
                Track track = new Track();
                track.setId(i + 1);
                track.setName(arraynode.get(i).path("name").asText());
                track.setComment(arraynode.get(i).path("artist").path("name").asText());
                //save it in the repo
                trackRepository.save(track);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }



        }

    }



