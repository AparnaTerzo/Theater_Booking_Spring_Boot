package com.example.theatre.service.impl;

import com.example.theatre.dto.CityDto;
import com.example.theatre.models.City;
import com.example.theatre.repository.CityRepository;
import com.example.theatre.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.theatre.mapper.CityMapper.mapToCity;
import static com.example.theatre.mapper.CityMapper.mapToCityDto;

@Service
public class CityServiceImpl  implements CityService {


    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City saveCity(CityDto cityDto) {
        City city = mapToCity(cityDto);
       return cityRepository.save(city);
    }

    @Override
    public List<CityDto> findAllCities() {
     List<City> city =cityRepository.findAll();
        return city.stream()
                .map((c) -> mapToCityDto(c)).collect(Collectors.toList());
    }

    @Override
    public List<City> searchCitiesByName(String cityName) {

        return cityRepository.findByCityName(cityName);
    }

}
