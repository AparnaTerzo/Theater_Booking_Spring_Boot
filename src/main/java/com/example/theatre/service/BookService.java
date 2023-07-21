package com.example.theatre.service;

import com.example.theatre.dto.BookingsDto;
import com.example.theatre.dto.MovieDto;
import com.example.theatre.dto.ShowDto;
import com.example.theatre.models.Bookings;
import com.example.theatre.models.ShowTiming;

import java.util.List;

public interface BookService {
    Bookings saveBook(BookingsDto bookingsDto);


    double calculatePrice(BookingsDto bookingsDto, ShowTiming showTiming);
    List<BookingsDto> getAllBookings();
}
