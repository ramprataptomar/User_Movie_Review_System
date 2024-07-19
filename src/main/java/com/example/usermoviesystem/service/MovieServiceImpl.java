package com.example.usermoviesystem.service;

import com.example.usermoviesystem.model.Movie;
import com.example.usermoviesystem.model.User;
import com.example.usermoviesystem.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
    public boolean addMovie(Movie movie) {
        movieRepository.save(movie);
        return true;
    }

    public Movie getMovie(int id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie updateNameById(int id, String name) {
        Movie movie = movieRepository.findById(id);
        movie.setMovieName(name);
        return movieRepository.save(movie);
    }

    public boolean deleteMovie(int id) {
        Movie movie = null;
        movie = movieRepository.findById(id);
        if(movie != null) {
            movieRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
