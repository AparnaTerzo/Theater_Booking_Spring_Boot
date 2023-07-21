package com.example.theatre.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreenDto {
    private int screenId;

    private String screenName;
    private int platinumSeats;
    private int goldSeats;
    private int silverSeats;
    private int capacity;
    private int theaterId;

}
