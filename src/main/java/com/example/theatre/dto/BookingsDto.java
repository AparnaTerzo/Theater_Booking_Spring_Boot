package com.example.theatre.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BookingsDto {
    private int bookId;
    private String customerName;
    private int platinumSeats;
    private int silverSeats;
    private int goldSeats;
    private double price;
    private String status;
    private Date date;
//    private int movieId;
//    private int screenId;
    private int showId;
//    private int theaterId;

}
