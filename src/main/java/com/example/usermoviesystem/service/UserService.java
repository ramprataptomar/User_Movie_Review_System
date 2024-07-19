package com.example.usermoviesystem.service;

import com.example.usermoviesystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    boolean addUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    User updateNameById(int id, String name);
    boolean deleteUserById(int id);
}
