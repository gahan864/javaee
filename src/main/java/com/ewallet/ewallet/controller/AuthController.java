package com.ewallet.ewallet.controller;

import com.ewallet.ewallet.model.User;
import com.ewallet.ewallet.repository.UserRepository;
import com.ewallet.ewallet.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = repo.findByEmail(user.getEmail());

        if (existingUser != null &&
                existingUser.getPassword().equals(user.getPassword())) {

            return jwtUtil.generateToken(existingUser.getEmail());
        }

        return "Invalid credentials";
    }
}