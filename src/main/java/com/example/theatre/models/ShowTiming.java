package com.example.theatre.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowTiming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;
    private LocalTime showTime;

    private Date showDate;
    private int platinumPrice;
    private int silverPrice;
    private int goldPrice;
    @ManyToOne()
    @JoinColumn(name = "theaterId")
    private Theater theater;

    @ManyToOne()
    @JoinColumn(name = "movieId")
    private Movies movie;

    @ManyToOne()
    @JoinColumn(name = "screenId")
    private Screen screen;

    @OneToMany(mappedBy = "show")
    private List<Bookings> bookings;


}
