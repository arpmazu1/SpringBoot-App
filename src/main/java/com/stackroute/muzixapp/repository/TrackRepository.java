package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//TrackRepository class
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    //using @Query for fetching track by name
    @Query("SELECT t FROM Track t WHERE t.name = ?1")
    Track findTrackByName(String name);
}
