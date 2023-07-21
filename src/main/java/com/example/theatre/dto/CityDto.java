package com.example.theatre.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDto {

    private int cityId;
    private String cityName;
}