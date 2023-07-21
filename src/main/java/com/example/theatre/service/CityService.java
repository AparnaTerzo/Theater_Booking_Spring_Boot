package com.example.theatre.service;

import com.example.theatre.dto.CityDto;
import com.example.theatre.models.City;

import java.util.List;

public interface CityService {
    City saveCity(CityDto cityDto);
    List<CityDto> findAllCities();

    List<City> searchCitiesByName(String cityName);

}
