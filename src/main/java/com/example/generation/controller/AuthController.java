package com.example.generation.controller;

import com.example.generation.dto.AuthResponse;
import com.example.generation.dto.LoginRequest;
import com.example.generation.dto.SignupRequest;
import com.example.generation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public AuthResponse register(@RequestBody SignupRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }
}
