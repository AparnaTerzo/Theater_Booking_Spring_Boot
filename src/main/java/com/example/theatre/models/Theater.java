package com.example.theatre.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterId;
    private String theaterName;
    private String theaterPlace;



    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private City city;

//    @OneToMany(mappedBy = "theater")
//    private List<Movies> movie;


    @OneToMany(mappedBy = "theater")
    private List<ShowTiming> shows;

//    @OneToMany(mappedBy = "theater")
//    private List<Bookings> bookings;

    @OneToMany(mappedBy = "theater")
    private List<Screen> screen;
}
