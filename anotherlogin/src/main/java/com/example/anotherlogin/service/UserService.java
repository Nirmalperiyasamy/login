package com.example.anotherlogin.service;

import com.example.anotherlogin.doa.UserDetails;
import com.example.anotherlogin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean isUsernameAlreadyTaken(String username) {
        return userRepo.existsByUsername(username);
    }

    public UserDetails addUser(UserDetails user) {
        userRepo.save(user);

        return user;
    }

    public UserDetails loginUser(UserDetails user) {
        if (isUsernameAlreadyTaken(user.getUsername())) {
            UserDetails demo = userRepo.findByUsername(user.getUsername());
            System.out.println(demo);
            if (demo.getPassword().equals(user.getPassword())) {
                demo.setUsername("validUser");

                return demo;
            } else {
                demo.setUsername("wrongPassword");

                return demo;
            }
        } else {
            UserDetails demo = new UserDetails();
            demo.setUsername("invalidUser");

            return demo;
        }
    }

    public List<UserDetails> getAll() {
        List<UserDetails> user = userRepo.findAll();

        return user;
    }
}
