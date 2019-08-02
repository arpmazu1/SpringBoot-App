package com.stackroute.muzixapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;



//track class
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {

        //variables

        private int id;

        private String name;

        private String comment;






}
