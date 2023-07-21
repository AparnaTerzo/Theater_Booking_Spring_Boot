package com.example.theatre.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String customerName;
    private int platinumSeats;
    private int silverSeats;
    private int goldSeats;
    private double price;
    private Date date;

    @ManyToOne
    @JsonBackReference
    private ShowTiming show;
//
//    @ManyToOne
//    @JsonBackReference
//    private Movies movie;
//
//    @ManyToOne
//    @JsonBackReference
//    private Screen screen;
//
//    @ManyToOne
//    @JsonBackReference
//    private Theater theater;

}
