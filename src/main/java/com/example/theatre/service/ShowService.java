package com.example.theatre.service;

import com.example.theatre.dto.ScreenDto;
import com.example.theatre.dto.ShowDto;
import com.example.theatre.dto.TheaterDto;

import java.util.List;

public interface ShowService {
    ShowDto saveShow(ShowDto showDto);
    List<ShowDto> getAllShows();

    List<ShowDto> getShowByMovieId(int movieId);
}
