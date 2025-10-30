package com.bus.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bus.beans.MovieDetails;

import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<MovieDetails, Long> {
    
    Optional<MovieDetails> findByMovieNameIgnoreCase(String movieName);
}
