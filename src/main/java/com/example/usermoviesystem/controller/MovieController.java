package com.example.usermoviesystem.controller;

import com.example.usermoviesystem.model.Movie;
import com.example.usermoviesystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public boolean addMovie(@RequestBody Movie movie) {
        boolean added = movieService.addMovie(movie);
        if(added) {
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("get/{id}")
    public Movie getMovieById(@PathVariable int id) {
        Movie movie = null;
        movie = movieService.getMovie(id);
        return movie;
    }

    @CrossOrigin("*")
    @GetMapping("getAll")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PutMapping("updateName/{id}")
    public Movie updateNameById(@PathVariable int id,@RequestBody String name) {
        Movie movie = null;
        movie = movieService.updateNameById(id, name);
        return movie;
    }

    @CrossOrigin("*")
    @DeleteMapping("delete/{id}")
    public boolean deleteMovie(@PathVariable int id) {
        return movieService.deleteMovie(id);
    }

}
