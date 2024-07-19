package com.example.usermoviesystem;

import com.example.usermoviesystem.model.User;
import org.springframework.util.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMovieSystemApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testUserClass() {
        User u = new User();
        Assert.isTrue(u instanceof User, "User Object creation failed");
    }

    @Test
    void testAnotherUserClass() {
        User u = new User(1,"raj","raj@123","02");
        Assert.isTrue(u instanceof User, "User Object creation failed");
    }

    @Test
    void testSettersAndGetters(){
        User u = new User();
        u.setUser_id(3);
        u.setUser_name("Rohit");
        u.setEmail("Rj@321");
        u.setFavoriteMovies("DDLJ");
        u.getUser_id();
        u.getUser_name();
        u.getEmail();
        u.getFavoriteMovies();
    }

    @Test
    void testEqualAndHashcode() {
        User u = new User();
        u.setUser_id(3);
        u.setUser_name("Rohit");
        u.setEmail("Rj@321");
        u.setFavoriteMovies("DDLJ");
        User u1 = new User(3, "Rohit", "Rj@321", "DDLJ");
        Assert.isTrue(u.equals(u1), "");
        Assert.isTrue(u.hashCode() == u1.hashCode(), "");
    }

    @Test
    void testToString() {
        String str = "User(user_id=1, user_name=rahul, email=rrr@111, favoriteMovies=Krish)";
        User u = new User(1, "rahul", "rrr@111", "Krish");
        System.out.println(u);
        System.out.println(str);
        Assert.isTrue(str.equals(u.toString()), "object failed");
    }

    @Test
    void testAddUser() {

    }

}
