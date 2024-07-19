package com.example.usermoviesystem.service;

import com.example.usermoviesystem.model.User;
import com.example.usermoviesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addUser(User user) {
        userRepository.save(user);
        return true;
    }
    public User getUserById(int id) {
        return userRepository.findById(id);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User updateNameById(int id, String name) {
        User u = userRepository.findById(id);
        u.setUserName(name);
        return userRepository.save(u);
    }
    public boolean deleteUserById(int id) {
        User user = null;
        user = userRepository.findById(id);
        if(user != null) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
