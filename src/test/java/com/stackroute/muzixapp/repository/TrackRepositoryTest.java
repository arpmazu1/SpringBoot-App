package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {
    @Autowired
    TrackRepository trackRepository;
    Track track;

    //setting up the values of track
    @Before
    public void setUp()
    {
        track = new Track();


        track.setId(101);
        track.setName("I'm so tired");
        track.setComment("Lauv");

    }

    //tear down all the tracks
    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }

    //test for savetrack method
    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertEquals(101,fetchTrack.getId());

    }

    @Test
    public void testTrackFailure(){
        Track testTrack = new Track(104,"Without me","Halsey");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(testTrack,track);
    }

    //test for updatetrack method
    @Test
    public void testUpdateTrack(){
        trackRepository.save(track);
        Track track1= new  Track(101,"I'm so tired","Troy and Lauv");
        trackRepository.save(track1);
        Track fetchTrack = trackRepository.findById(track1.getId()).get();
        Assert.assertEquals(track1,fetchTrack);

    }

    //track for deleteTrack method
    @Test
    public void deleteTrack(){
       trackRepository.save(track);
       Assert.assertNotNull(trackRepository.findById(track.getId()).orElse(null));
        trackRepository.delete(track);
        Assert.assertNull(trackRepository.findById(track.getId()).orElse(null));
    }

    //test for getallTrack method
    @Test
    public void testGetAllTrack(){
        Track u = new Track(102,"Happier","Marshmello");
        Track u1 = new Track(103,"Eastside","Khalid");
        trackRepository.save(u);
        trackRepository.save(u1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Happier",list.get(0).getName());




    }


}

