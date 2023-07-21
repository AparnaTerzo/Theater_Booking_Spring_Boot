package com.example.theatre.repository;

import com.example.theatre.models.Movies;
import com.example.theatre.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {
//    List<Movies> findMoviesByTheater_TheaterId(int threaterId);

}
