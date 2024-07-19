package com.example.usermoviesystem.repository;

import com.example.usermoviesystem.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findById(int id);

}
