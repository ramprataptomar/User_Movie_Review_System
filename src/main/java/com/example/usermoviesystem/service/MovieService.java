package com.example.usermoviesystem.service;

import com.example.usermoviesystem.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    boolean addMovie(Movie movie);
    Movie getMovie(int id);
    List<Movie> getAllMovies();
    Movie updateNameById(int id, String name);
    boolean deleteMovie(int id);

}
