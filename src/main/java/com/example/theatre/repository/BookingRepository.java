package com.example.theatre.repository;

import com.example.theatre.models.Bookings;
import com.example.theatre.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Integer> {

}
