package com.example.theatre.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String movieName;
    private int duration;
    private String language;
    private String description;
    private String posterUrl;
    private String cast;
    private LocalDate releaseDate;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },
//            mappedBy = "movies")
//    @JsonIgnore
//    private Set<Theater> theaters = new HashSet<>();

//    @ManyToOne()
//    @JoinColumn(name = "theaterId")
//    private Theater theater;

    @OneToMany(mappedBy = "movie")
    public List<ShowTiming> shows;

//    @OneToMany(mappedBy="movie")
//    private List<Bookings> bookings;


}
