package com.example.theatre.service.impl;

import com.example.theatre.dto.TheaterDto;
import com.example.theatre.mapper.TheaterMapper;
import com.example.theatre.models.City;
import com.example.theatre.models.Theater;
import com.example.theatre.repository.CityRepository;
import com.example.theatre.repository.TheaterRepository;
import com.example.theatre.service.TheaterService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.theatre.mapper.TheaterMapper.mapToTheaterDto;

@Service
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final CityRepository cityRepository;
    private final TheaterMapper theaterMapper;

    @Autowired
    public TheaterServiceImpl(TheaterRepository theaterRepository, CityRepository cityRepository, TheaterMapper theaterMapper) {
        this.theaterRepository = theaterRepository;
        this.cityRepository = cityRepository;
        this.theaterMapper = theaterMapper;
    }


    @Override
    public TheaterDto saveTheater(TheaterDto theaterDto) {

        City city = cityRepository.findById(theaterDto.getCityId())
                .orElseThrow(() -> new EntityNotFoundException("City not found with ID: " + theaterDto.getCityId()));
        Theater theater = TheaterMapper.mapToTheater(theaterDto);
        theater.setCity(city);

        Theater savedTheater = theaterRepository.save(theater);

        return mapToTheaterDto(savedTheater);
    }


        @Override
        public List<TheaterDto> getAllTheaters() {
            List<Theater> theaters = theaterRepository.findAll();
            return theaters.stream()
                    .map((t) -> mapToTheaterDto(t)).collect(Collectors.toList());
        }

    @Override
    public List<TheaterDto> getTheatersByCityId(int cityId) {
        List<Theater> theaters = theaterRepository.findByCity_CityId(cityId);
        return theaters.stream()
                .map((t) -> mapToTheaterDto(t)).collect(Collectors.toList());
    }

    }





