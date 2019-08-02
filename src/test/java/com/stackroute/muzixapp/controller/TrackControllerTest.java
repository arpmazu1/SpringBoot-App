package com.stackroute.muzixapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.GlobalException;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.service.TrackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TrackControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Track track;

    //creating a mockbean of trackservice
    @MockBean
    private TrackService trackService;

    //injecting trackcontroller
    @InjectMocks
    private TrackController trackController;
    //creating a list of track
    List<Track> list = null;

    //setting up values for track
    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).setControllerAdvice(GlobalException.class).build();
        track = new Track();

        track.setId(101);
        track.setName("Take me to church");
        track.setComment("Hozier");
        list = new ArrayList();

        list.add(track);
    }

    //testing savetrack method
    @Test
    public void saveTrack() throws Exception {
        when(trackService.saveTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    public void saveTrackFailure() throws Exception {
        when(trackService.saveTrack(any())).thenThrow(TrackAlreadyExistsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    //testing the the deletetrack function
    @Test
    public void deleteTrack() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/track/1"))
                //.contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //testing the updatetrack method
    @Test
    public void updateTrack() throws Exception {
        when(trackService.updateTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/id")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }

    //testin the getalltracks metohd
    @Test
    public void getAllTrack() throws Exception {
        when(trackService.getAllTracks()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    //asJsonString method
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
