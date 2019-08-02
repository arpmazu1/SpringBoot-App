package com.stackroute.muzixapp;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.service.TrackService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//main Spring boot Application
//using commandlinerunner
@SpringBootApplication
public class MuzixAppApplication implements CommandLineRunner {

    TrackService trackService;

    @Autowired
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    protected final Log logger = LogFactory.getLog(getClass());


    @Override
    public void run(String... args) throws Exception {
        trackService.saveTrack(new Track(23, "Main hoon hero tera", "Hindi"));
        trackService.saveTrack(new Track(34, "Take me to church", "English"));
        trackService.saveTrack(new Track(43, "Despasito", "Spanish"));

        logger.info("Application Started !!");

    }

    public static void main(String[] args) {
        SpringApplication.run(MuzixAppApplication.class, args);
    }


}
