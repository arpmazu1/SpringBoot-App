package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.repository.TrackRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.h2.command.dml.MergeUsing;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class TrackServiceTest {


    Track track;

    //Creating a mock for UserRepository
    @Mock
    TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;


    //setting up the values
    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();

        track.setId(101);
        track.setName("Girls like you");
        track.setComment("Maroon 5");
        list = new ArrayList<>();
        list.add(track);


    }

    //test for saveTrack method
    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }


    @Test(expected = TrackAlreadyExistsException.class)
    public void saveTrackTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track)any())).thenReturn(null);
        Track savedTrack = trackService.saveTrack(track);
        System.out.println("savedTrack" + savedTrack);
        //Assert.assertEquals(track,savedTrack);

       /*doThrow(new TrackAlreadyExistException()).when(trackRepository).findById(eq(101));
       trackService.saveTrack(track);*/
    }

    //test for deleteTrack method
    @Test
    public void deleteTrack(){
            trackService.deleteTrack(101);
            verify(trackRepository, times(1)).deleteById(101);    }


    //test for updateTrack method
    @Test
    public void updateTrackTestSuccess()  {
        Track track1 = new Track(101,"Girls like you","Maroon 5 & Cardi B ");
        when(trackRepository.save((Track) any())).thenReturn(track1);

        Track savedTrack =
                trackService.updateTrack(track1);

        Assert.assertEquals(track1.toString(),savedTrack.toString());


        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track1);

    }


    //
    @Test
    public void getAllTrack(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> userlist = trackService.getAllTracks();
        Assert.assertEquals(list,userlist);
    }

}
