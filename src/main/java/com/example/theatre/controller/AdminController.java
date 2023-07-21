package com.example.theatre.controller;


import com.example.theatre.dto.*;
import com.example.theatre.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AdminController {

    private final CityService cityService;
    private final MovieService movieService;
    private final TheaterService theaterService;
    private final ScreenService screenService;
    private final ShowService showService;
    private final BookService bookService;

    @PostMapping("/city/add")
    public void saveCity(@RequestBody CityDto cityDto){
        cityService.saveCity(cityDto);

    }



    @PostMapping("/theater/add")
    public void saveTheater(@RequestBody TheaterDto theaterDto) {
        TheaterDto savedTheater = theaterService.saveTheater(theaterDto);
    }

    @PostMapping("/movie/add")
    public void saveMovie( @RequestBody MovieDto movieDto) {
        MovieDto save = movieService.saveMovie(movieDto);

    }


    @PostMapping("/screen/add")
    public void saveScreen(@RequestBody ScreenDto screenDto) {
        ScreenDto screen = screenService.saveScreen(screenDto);
    }


    @PostMapping("/show/add")
    public void saveShow(@RequestBody ShowDto showDto) {

        ShowDto show = showService.saveShow(showDto);
    }

    @GetMapping("/bookings")
    public List<BookingsDto> listBookings(){
        List<BookingsDto> bookings= bookService.getAllBookings();
        return bookings;
    }


}
