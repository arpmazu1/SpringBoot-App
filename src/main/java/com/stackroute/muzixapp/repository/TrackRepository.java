package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//TrackRepository class
@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {
    //using @Query for fetching track by name
    //@Query("SELECT t FROM Track t WHERE t.name = ?1")
    List<Track> findByName(String name);
}
