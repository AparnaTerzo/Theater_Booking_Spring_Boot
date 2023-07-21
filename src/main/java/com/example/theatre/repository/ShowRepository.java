package com.example.theatre.repository;

import com.example.theatre.models.Movies;
import com.example.theatre.models.ShowTiming;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<ShowTiming, Integer> {
    List<ShowTiming> findShowTimingByMovie_MovieId(int movieId);
}
