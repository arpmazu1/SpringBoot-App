package com.stackroute.muzixapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//track class
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {

        //variables
        @Id
        private int id;
        @Column
        private String name;
        @Column
        private String comment;






}
