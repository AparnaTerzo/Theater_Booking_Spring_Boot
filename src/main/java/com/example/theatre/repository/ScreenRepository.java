package com.example.theatre.repository;

import com.example.theatre.models.Screen;
import com.example.theatre.models.ShowTiming;
import com.example.theatre.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {

    List<Screen> findScreensByTheater_TheaterId(int theaterId);
}
