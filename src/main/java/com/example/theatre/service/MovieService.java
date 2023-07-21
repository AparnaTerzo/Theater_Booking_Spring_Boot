package com.example.theatre.service;

import com.example.theatre.dto.MovieDto;
import com.example.theatre.dto.TheaterDto;
import com.example.theatre.models.Movies;
import jakarta.transaction.Transactional;

import java.util.List;

public interface MovieService {


    MovieDto saveMovie(MovieDto movieDto);
    List<MovieDto> getAllMovies();

//    List<MovieDto> getMoviesByTheaterId( int theaterId);



}
