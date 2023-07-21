package com.example.theatre.mapper;

import com.example.theatre.dto.MovieDto;
import com.example.theatre.dto.TheaterDto;
import com.example.theatre.models.Movies;
import com.example.theatre.models.Theater;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MovieMapper {

        public static Movies mapToMovie(MovieDto movieDto) {

            Movies movie = Movies.builder()
                    .movieId(movieDto.getMovieId())
                    .movieName(movieDto.getMovieName())
                    .duration(movieDto.getDuration())
                    .language(movieDto.getLanguage())
                    .description(movieDto.getDescription())
                    .posterUrl(movieDto.getPosterUrl())
                    .cast(movieDto.getCast())
                    .releaseDate(movieDto.getReleaseDate())
                    .build();

            return movie;
        }

        public static MovieDto mapToMovieDto(Movies movie) {

            MovieDto movieDto = MovieDto.builder()
                    .movieId(movie.getMovieId())
                    .movieName(movie.getMovieName())
                    .language(movie.getLanguage())
                    .description(movie.getDescription())
                    .duration(movie.getDuration())
                    .posterUrl(movie.getPosterUrl())
                    .cast(movie.getCast())
                    .releaseDate(movie.getReleaseDate())
                    .build();

            return movieDto;
        }
    }


