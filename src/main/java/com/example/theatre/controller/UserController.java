package com.example.theatre.controller;

import com.example.theatre.dto.*;
import com.example.theatre.models.Bookings;
import com.example.theatre.models.City;
import com.example.theatre.models.Theater;
import com.example.theatre.service.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final CityService cityService;
    private final TheaterService theaterService;
    private final MovieService movieService;
    private final ScreenService screenService;
    private final ShowService showService;
    private final BookService bookService;

    @GetMapping("/city")
    public List<CityDto> listCity(){
        List<CityDto> city = cityService.findAllCities();
        return city;
    }

    //To search a city
    @GetMapping("/city/search")
    public List<City> searchCitiesByName(@RequestParam("name") String cityName) {
        return cityService.searchCitiesByName(cityName);
    }


    @GetMapping("/theater")
    public List<TheaterDto> listTheater(){
        List<TheaterDto> theater = theaterService.getAllTheaters();
        return theater;
    }
    @GetMapping("/theater/{cityId}")
    public List<TheaterDto> getTheatersByCityId(@PathVariable int cityId) {
        List<TheaterDto> theaters = theaterService.getTheatersByCityId(cityId);
        return theaters;
    }


    @GetMapping("/movie")
    public List<MovieDto> listMovie(){
        List<MovieDto> movie = movieService.getAllMovies();
        return movie;
    }


    @GetMapping("/screen")
    public List<ScreenDto> listScreen(){
        List<ScreenDto> screen = screenService.getAllScreens();
        return screen;
    }
    @GetMapping("/show")
    public List<ShowDto> listShow(){
        List<ShowDto> show = showService.getAllShows();
        return show;
    }
    @GetMapping("/show/{movieId}")
    public List<ShowDto> getShowsByMovieId(@PathVariable int movieId) {
        List<ShowDto> show = showService.getShowByMovieId(movieId);
        return show;
    }

    @GetMapping("/screen/{theaterId}")
    public List<ScreenDto> getScreenByShowId(@PathVariable int theaterId) {
        List<ScreenDto> screen = screenService.getScreenByTheatreId(theaterId);
        return screen;
    }

    @PostMapping("show/{showId}/bookings")
    public BookingsDto  bookSeatForShow(@PathVariable int showId,@RequestBody BookingsDto bookingsDto){
        bookingsDto.setShowId(showId);
        Bookings bookings=bookService.saveBook(bookingsDto);

         if( bookings== null){
             bookingsDto.setStatus("jj");
             return bookingsDto;

         }
         else{
             bookingsDto.setStatus("Success");
             bookingsDto.setBookId(bookings.getBookId());
             return bookingsDto;
         }

    }





}
