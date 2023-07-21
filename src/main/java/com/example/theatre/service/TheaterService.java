package com.example.theatre.service;

import com.example.theatre.dto.TheaterDto;
import com.example.theatre.models.City;

import java.util.List;

public interface TheaterService {
    TheaterDto saveTheater(TheaterDto theaterDto);
    List<TheaterDto> getAllTheaters();

    List<TheaterDto> getTheatersByCityId( int cityId);
}
