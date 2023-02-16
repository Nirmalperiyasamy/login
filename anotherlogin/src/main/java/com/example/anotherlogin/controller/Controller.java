package com.example.anotherlogin.controller;

import com.example.anotherlogin.doa.UserDetails;
import com.example.anotherlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.anotherlogin.Constant;

@RestController
@RequestMapping("api")
public class Controller {
    @Autowired
    private UserService userService;

    public UserService getUserService() {

        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDetails> getAll() {

        return userService.getAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody UserDetails user) {
        user = userService.addUser(user);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDetails user) {
        user = userService.loginUser(user);

        switch (user.getUsername()) {
            case "validUser":

                return ResponseEntity.ok("Login successfully");

            case "wrongPassword":

                return ResponseEntity.ok("Wrong password");

            case "invalidUser":

                return ResponseEntity.ok("username does not exist");
            default:

                return ResponseEntity.ok("wait");
        }
    }
}
