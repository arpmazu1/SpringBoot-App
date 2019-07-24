package com.stackroute.muzixapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//track class
@Entity
public class Track {

        //variables
        @Id
        private int id;
        @Column
        private String name;
        @Column
        private String comment;


        //constructor
        public Track() {
        }

        public Track(int id, String name, String comment) {
            this.id = id;
            this.name = name;
            this.comment = comment;
        }

        //getter and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }


        //to string mehod
        @Override
        public String toString() {
            return "Track{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", comment='" + comment + '\'' +
                    '}';
        }





}
