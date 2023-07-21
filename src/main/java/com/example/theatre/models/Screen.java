package com.example.theatre.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenId;

    private String screenName;
    private int platinumSeats;
    private int goldSeats;
    private int silverSeats;
    private int capacity;

    @OneToMany(mappedBy = "screen")
    private List<ShowTiming> shows;

//    @OneToMany(mappedBy = "screen")
//    private List<Bookings> bookings;
    @ManyToOne
    private Theater theater;



}
