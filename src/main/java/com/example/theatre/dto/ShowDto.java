package com.example.theatre.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
public class ShowDto {

    private int showId;
    private LocalTime showTime;

    private Date showDate;
    private int platinumPrice;
    private int silverPrice;
    private int goldPrice;
    private int movieId;
    private int screenId;
    private int theaterId;
}
