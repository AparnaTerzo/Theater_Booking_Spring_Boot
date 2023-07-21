package com.example.theatre.mapper;

import com.example.theatre.dto.CityDto;
import com.example.theatre.dto.TheaterDto;
import com.example.theatre.models.City;
import com.example.theatre.models.Theater;
import org.springframework.stereotype.Component;

@Component
public class TheaterMapper {

    public static Theater mapToTheater(TheaterDto theaterDto) {

        Theater theater = Theater.builder()
                .theaterId(theaterDto.getTheaterId())
                .theaterName(theaterDto.getTheaterName())
                .theaterPlace(theaterDto.getTheaterPlace())

                .build();
        return theater;
    }

    public static TheaterDto mapToTheaterDto(Theater theater) {

        TheaterDto theaterDto = TheaterDto.builder()
                .theaterId(theater.getTheaterId())
                .theaterName(theater.getTheaterName())
                .theaterPlace(theater.getTheaterPlace())
                .cityId(theater.getCity().getCityId())
                .build();
        return theaterDto;
    }
}
