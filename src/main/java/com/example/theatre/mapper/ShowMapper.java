package com.example.theatre.mapper;

import com.example.theatre.dto.ShowDto;
import com.example.theatre.models.ShowTiming;
import org.springframework.stereotype.Component;

@Component
public class ShowMapper {
        public static ShowTiming mapToShow(ShowDto showDto) {

            ShowTiming showTiming = ShowTiming.builder()
                    .showId(showDto.getShowId())
                    .showDate(showDto.getShowDate())
                    .showTime(showDto.getShowTime())
                    .goldPrice(showDto.getGoldPrice())
                    .platinumPrice(showDto.getPlatinumPrice())
                    .silverPrice(showDto.getSilverPrice())

                    .build();
            return showTiming;
        }

        public static ShowDto mapToShowDto(ShowTiming show) {

            ShowDto showDto = ShowDto.builder()
                    .showId(show.getShowId())
                    .showTime(show.getShowTime())
                    .showDate(show.getShowDate())
                    .silverPrice(show.getSilverPrice())
                    .platinumPrice(show.getPlatinumPrice())
                    .goldPrice(show.getGoldPrice())
                    .movieId(show.getMovie().getMovieId())
                    .theaterId(show.getTheater().getTheaterId())
                    .screenId(show.getScreen().getScreenId())
                    .build();
            return showDto;
        }
    }



