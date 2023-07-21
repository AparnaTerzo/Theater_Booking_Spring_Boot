package com.example.theatre.service.impl;

import com.example.theatre.dto.BookingsDto;
import com.example.theatre.mapper.BookingMapper;
import com.example.theatre.models.Bookings;
import com.example.theatre.models.Screen;
import com.example.theatre.models.ShowTiming;
import com.example.theatre.repository.BookingRepository;
import com.example.theatre.repository.ScreenRepository;
import com.example.theatre.repository.ShowRepository;
import com.example.theatre.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.theatre.mapper.BookingMapper.mapToBookingDto;
import static com.example.theatre.mapper.ScreenMapper.mapToScreenDto;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookingMapper bookingsMapper;
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final ScreenRepository screenRepository;

    @Override
    public Bookings saveBook(BookingsDto bookingsDto) {
        ShowTiming showTiming = showRepository.findById(bookingsDto.getShowId()).get();
        double price = calculatePrice(bookingsDto, showTiming);
        bookingsDto.setPrice(price);


        Bookings bookings = bookingsMapper.mapToBooking(bookingsDto);

        bookings.setShow(showTiming);
//        bookings.setScreen(showTiming.getScreen());
//        bookings.setTheater(showTiming.getTheater());
//        bookings.setMovie(showTiming.getMovie());
        Screen screen = showTiming.getScreen();
        screen.setGoldSeats(screen.getGoldSeats()-bookings.getGoldSeats());//Deduct Gold seats when a user books
        screen.setPlatinumSeats(screen.getPlatinumSeats()-bookings.getPlatinumSeats());
        screen.setSilverSeats(screen.getSilverSeats()-bookings.getSilverSeats());
        screen.setCapacity(screen.getCapacity()-bookings.getSilverSeats()-bookings.getPlatinumSeats()-bookings.getGoldSeats());
        return bookingRepository.save(bookings);
    }




    public double calculatePrice(BookingsDto bookingsDto, ShowTiming showTiming) {



        double totalPlatinumPrice = showTiming.getPlatinumPrice()*bookingsDto.getPlatinumSeats();
        double totalSilverPrice = showTiming.getSilverPrice()*bookingsDto.getSilverSeats();
        double totalGoldPrice = showTiming.getGoldPrice()*bookingsDto.getGoldSeats();

        return totalPlatinumPrice + totalSilverPrice + totalGoldPrice;
    }

    @Override
    public List<BookingsDto> getAllBookings() {
        List<Bookings> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map((t) -> mapToBookingDto(t)).collect(Collectors.toList());
    }


}
