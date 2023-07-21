package com.example.theatre.service;

import com.example.theatre.dto.ScreenDto;
import com.example.theatre.dto.ShowDto;
import com.example.theatre.dto.TheaterDto;

import java.util.List;

public interface ScreenService {
    ScreenDto saveScreen(ScreenDto screenDto);
    List<ScreenDto> getAllScreens();

    List<ScreenDto> getScreenByTheatreId(int theaterId);
}
