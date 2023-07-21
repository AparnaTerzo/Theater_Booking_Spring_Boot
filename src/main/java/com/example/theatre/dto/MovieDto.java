package com.example.theatre.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class MovieDto {
    private int movieId;
    private String movieName;
    private int duration;
    private String language;
    private String description;
    private String posterUrl;
    private String cast;
    private LocalDate releaseDate;



}
