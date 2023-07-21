package com.example.theatre.service.impl;

import com.example.theatre.dto.ScreenDto;
import com.example.theatre.dto.ShowDto;
import com.example.theatre.mapper.ScreenMapper;
import com.example.theatre.mapper.ShowMapper;
import com.example.theatre.models.Movies;
import com.example.theatre.models.Screen;
import com.example.theatre.models.ShowTiming;
import com.example.theatre.models.Theater;
import com.example.theatre.repository.MovieRepository;
import com.example.theatre.repository.ScreenRepository;
import com.example.theatre.repository.ShowRepository;
import com.example.theatre.repository.TheaterRepository;
import com.example.theatre.service.ShowService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.theatre.mapper.MovieMapper.mapToMovieDto;
import static com.example.theatre.mapper.ScreenMapper.mapToScreenDto;
import static com.example.theatre.mapper.ShowMapper.mapToShowDto;

@RequiredArgsConstructor
@Service
public class ShowServiceImpl implements ShowService {
    private final ShowMapper showMapper;
    private final TheaterRepository theaterRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;
    private final ShowRepository showRepository;
    @Override
    public ShowDto saveShow(ShowDto showDto) {
        Theater theater = theaterRepository.findById(showDto.getTheaterId())
                .orElseThrow(() -> new EntityNotFoundException("Theater not found with ID: " + showDto.getTheaterId()));
        Movies movie = movieRepository.findById(showDto.getMovieId())
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with ID: " + showDto.getMovieId()));
        Screen screen =screenRepository.findById(showDto.getScreenId())
                .orElseThrow(() -> new EntityNotFoundException("Screen not found with ID: " + showDto.getScreenId()));

        ShowTiming show = showMapper.mapToShow(showDto);
        show.setTheater(theater);
        show.setMovie(movie);
        show.setScreen(screen);

        ShowTiming save = showRepository.save(show);
        return mapToShowDto(save);

    }



    @Override
    public List<ShowDto> getAllShows() {
        List<ShowTiming> shows = showRepository.findAll();
        return shows.stream()
                .map((t) -> mapToShowDto(t)).collect(Collectors.toList());
    }

    @Override
    public List<ShowDto> getShowByMovieId(int movieId) {
        List<ShowTiming> show = showRepository.findShowTimingByMovie_MovieId(movieId);
        return show.stream()
                .map((t) -> mapToShowDto(t)).collect(Collectors.toList());
    }
}
