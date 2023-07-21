// BookingsMapper.java
package com.example.theatre.mapper;

import com.example.theatre.dto.BookingsDto;
import com.example.theatre.models.Bookings;
import com.example.theatre.repository.ShowRepository;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {


    public static Bookings mapToBooking(BookingsDto bookingsDto) {
        Bookings bookings = Bookings.builder()
                .bookId(bookingsDto.getBookId())
                .customerName(bookingsDto.getCustomerName())
                .date(bookingsDto.getDate())
                .price(bookingsDto.getPrice())
                .platinumSeats(bookingsDto.getPlatinumSeats())
                .goldSeats(bookingsDto.getGoldSeats())
                .silverSeats(bookingsDto.getSilverSeats())

                .build();
        return bookings;
    }

    public static BookingsDto mapToBookingDto(Bookings bookings) {

        BookingsDto bookingsDto = BookingsDto.builder()
                .bookId(bookings.getBookId())
                .customerName(bookings.getCustomerName())
                .date(bookings.getDate())
                .price(bookings.getPrice())
                .platinumSeats(bookings.getPlatinumSeats())
                .goldSeats(bookings.getGoldSeats())
                .silverSeats(bookings.getSilverSeats())
                .showId(bookings.getShow().getShowId())
                .build();
        return bookingsDto;
    }
}
