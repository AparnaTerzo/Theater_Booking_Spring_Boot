package com.example.theatre.mapper;

import com.example.theatre.dto.CityDto;
import com.example.theatre.models.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public static City mapToCity(CityDto cityDto) {

        City city = City.builder()
                .cityId(cityDto.getCityId())
                .cityName(cityDto.getCityName())
                .build();
        return city;
    }

    public static CityDto mapToCityDto(City city) {

        CityDto cityDto = CityDto.builder()
                .cityId(city.getCityId())
                .cityName(city.getCityName())
                .build();

        return cityDto;
    }
}


