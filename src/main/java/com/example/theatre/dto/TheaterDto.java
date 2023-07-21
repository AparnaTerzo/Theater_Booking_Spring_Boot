package com.example.theatre.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterDto {
    private int theaterId;
    private String theaterName;
    private String theaterPlace;
    private int cityId;
}
