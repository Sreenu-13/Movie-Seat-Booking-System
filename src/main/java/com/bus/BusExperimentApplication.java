package com.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.bus.beans.MovieDetails;
import com.bus.service.MovieService;

import java.util.Optional;

@SpringBootApplication
@EnableCaching
public class BusExperimentApplication implements CommandLineRunner {

    @Autowired
    private MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(BusExperimentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        movieService.addMovie(new MovieDetails("GOAT", "goat.jpg", "After years of successful operations, an elite agent suddenly retires, choosing a quiet, ordinary life."));
        movieService.addMovie(new MovieDetails("Sagavu", "sagavu.jpg", "Kichu is a heartless student leader who can go to any extent for power."));
        movieService.addMovie(new MovieDetails("KGF", "kgf.jpg", "Rocky, a young man, seeks power and wealth in order to fulfil a promise to his dying mother."));
        movieService.addMovie(new MovieDetails("LEO", "leo.jpg", "Things start to take an awry turn for a mild-mannered cafe owner, who gets caught in the crosshairs of a drug cartel."));
        movieService.addMovie(new MovieDetails("Kali", "kali.jpg", "Siddharth often has problems with his wife Anjali owing to his short temper."));
        movieService.addMovie(new MovieDetails("Mayanadhi", "mayanadhi.jpg", "Maathen, who works for a gang, is on the run after accidentally killing a police officer."));
        movieService.addMovie(new MovieDetails("Master", "Master.jpeg", "An alcoholic professor is enrolled to teach at a juvenile facility, unbeknownst to him."));
        movieService.addMovie(new MovieDetails("Thunivu", "Thunivu.jpg", "A group of gangsters plot to steal money from a bank. However, when they execute their plan."));
        movieService.addMovie(new MovieDetails("Vikram", "Vikram.jpeg", "A special agent investigates a murder committed by a masked group of serial killers."));
  
    }

    private void addMovieIfNotExists(String movieName, String image, String movieDetails) {
        Optional<MovieDetails> existingMovie = movieService.findByMovieName(movieName);
        if (!existingMovie.isPresent()) {
            movieService.addMovie(new MovieDetails(movieName, image, movieDetails));
        }
    }
}
