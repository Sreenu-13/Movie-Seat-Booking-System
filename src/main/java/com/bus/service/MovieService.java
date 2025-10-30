package com.bus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.beans.MovieDetails;

import antlr.collections.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    // Add new movie
    public MovieDetails addMovie(MovieDetails movieDetails) {
        movieDetails.setMovieName(movieDetails.getMovieName().trim().toLowerCase()); // Normalize name
        return movieRepo.save(movieDetails);
    }

    // Find movie by name (ignores case)
    public Optional<MovieDetails> findByMovieName(String movieName) {
        return movieRepo.findByMovieNameIgnoreCase(movieName.trim().toLowerCase());  // Query by normalized name
    }

    // Other methods for fetching, updating, and deleting movies
    public Optional<MovieDetails> getMovieById(Long id) {
        return movieRepo.findById(id);
    }

    /*public List<MovieDetails> getAllMovies() {
        return movieRepo.findAll();
    }*/

    public void deleteMovie(Long id) {
        movieRepo.deleteById(id);
    }

    public MovieDetails updateMovie(Long id, MovieDetails updatedMovie) {
        Optional<MovieDetails> existingMovie = movieRepo.findById(id);
        if (existingMovie.isPresent()) {
            MovieDetails movie = existingMovie.get();
            movie.setMovieName(updatedMovie.getMovieName().trim().toLowerCase());
            movie.setImage(updatedMovie.getImage());
            movie.setMovieDetails(updatedMovie.getMovieDetails());
            return movieRepo.save(movie);
        } else {
            return null; 
        }
    }
}
