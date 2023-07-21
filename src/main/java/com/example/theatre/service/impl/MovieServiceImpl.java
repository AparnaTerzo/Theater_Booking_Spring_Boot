package com.example.theatre.service.impl;

import com.example.theatre.dto.MovieDto;
import com.example.theatre.dto.TheaterDto;
import com.example.theatre.mapper.MovieMapper;
import com.example.theatre.mapper.TheaterMapper;
import com.example.theatre.models.City;
import com.example.theatre.models.Movies;
import com.example.theatre.models.Theater;
import com.example.theatre.repository.MovieRepository;
import com.example.theatre.repository.TheaterRepository;
import com.example.theatre.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.theatre.mapper.MovieMapper.mapToMovie;
import static com.example.theatre.mapper.MovieMapper.mapToMovieDto;
import static com.example.theatre.mapper.TheaterMapper.mapToTheaterDto;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;





    @Override
    public MovieDto saveMovie(MovieDto movieDto) {
        Theater theater = theaterRepository.findById(movieDto.getTheaterId())
                .orElseThrow(() -> new EntityNotFoundException("Threater not found with Id: " + movieDto.getTheaterId()));
        Movies movie = MovieMapper.mapToMovie(movieDto);
        Movies save = movieRepository.save(movie);

        return mapToMovieDto(save);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movies> movies = movieRepository.findAll();
        return movies.stream()
                .map((m) -> mapToMovieDto(m)).collect(Collectors.toList());

    }

//    @Override
//    public List<MovieDto> getMoviesByTheaterId(int theaterId) {
//        List<Movies> movies = movieRepository.findMoviesByTheater_TheaterId(theaterId);
//        return movies.stream()
//                .map((t) -> mapToMovieDto(t)).collect(Collectors.toList());
//    }


}
