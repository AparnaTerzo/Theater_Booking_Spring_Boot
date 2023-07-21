package com.example.theatre.mapper;

import com.example.theatre.dto.CityDto;
import com.example.theatre.dto.ScreenDto;
import com.example.theatre.dto.TheaterDto;
import com.example.theatre.models.City;
import com.example.theatre.models.Screen;
import com.example.theatre.models.Theater;
import org.springframework.stereotype.Component;

@Component
public class ScreenMapper {

    public static Screen mapToScreen(ScreenDto screenDto) {

        Screen screen = Screen.builder()
                .screenId(screenDto.getScreenId())
                .screenName(screenDto.getScreenName())
                .capacity(screenDto.getCapacity())
                .goldSeats(screenDto.getGoldSeats())
                .platinumSeats(screenDto.getPlatinumSeats())
                .silverSeats(screenDto.getSilverSeats())
                .build();
        return screen;
    }

    public static ScreenDto mapToScreenDto(Screen screen) {

        ScreenDto screenDto = ScreenDto.builder()
                .screenId(screen.getScreenId())
                .screenName(screen.getScreenName())
                .capacity(screen.getCapacity())
                .platinumSeats(screen.getPlatinumSeats())
                .silverSeats(screen.getSilverSeats())
                .goldSeats(screen.getGoldSeats())
                .theaterId(screen.getTheater().getTheaterId())
                .build();
        return screenDto;
    }
}
