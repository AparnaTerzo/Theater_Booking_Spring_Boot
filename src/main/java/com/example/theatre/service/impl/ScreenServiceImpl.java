package com.example.theatre.service.impl;

import com.example.theatre.dto.ScreenDto;
import com.example.theatre.dto.TheaterDto;
import com.example.theatre.mapper.ScreenMapper;
import com.example.theatre.mapper.TheaterMapper;
import com.example.theatre.models.City;
import com.example.theatre.models.Screen;
import com.example.theatre.models.ShowTiming;
import com.example.theatre.models.Theater;
import com.example.theatre.repository.ScreenRepository;
import com.example.theatre.repository.TheaterRepository;
import com.example.theatre.service.ScreenService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.theatre.mapper.ScreenMapper.mapToScreenDto;
import static com.example.theatre.mapper.ShowMapper.mapToShowDto;
import static com.example.theatre.mapper.TheaterMapper.mapToTheaterDto;

@RequiredArgsConstructor
@Service
public class ScreenServiceImpl implements ScreenService {

    private final ScreenMapper screenMapper;
    private final ScreenRepository screenRepository;
    private final TheaterRepository theaterRepository;

    @Override
    public ScreenDto saveScreen(ScreenDto screenDto) {
        Theater theater = theaterRepository.findById(screenDto.getTheaterId())
                .orElseThrow(() -> new EntityNotFoundException("City not found with ID: " + screenDto.getTheaterId()));

        Screen screen = ScreenMapper.mapToScreen(screenDto);
        screen.setTheater(theater);

        Screen save=screenRepository.save(screen);
        return mapToScreenDto(save);

    }


    @Override
    public List<ScreenDto> getAllScreens() {
        List<Screen> screens = screenRepository.findAll();
        return screens.stream()
                .map((t) -> mapToScreenDto(t)).collect(Collectors.toList());
    }

    @Override
    public List<ScreenDto> getScreenByTheatreId(int theaterId) {
        List<Screen> screen = screenRepository.findScreensByTheater_TheaterId(theaterId);
        return screen.stream()
                .map((t) -> mapToScreenDto(t)).collect(Collectors.toList());
    }


}
