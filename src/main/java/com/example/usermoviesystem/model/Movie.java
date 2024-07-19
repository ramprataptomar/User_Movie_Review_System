package com.example.usermoviesystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(nullable = false)
    private String movieName;

    @Column(nullable = false)
    private String Genre;

    private int releaseYear;

    private double rating;

    @OneToMany()
    private User user;

}
