package com.example.usermoviesystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne()
    @JoinColumn(name = "favoriteMovies")
    private List<Movie> favoriteMovies;
}
