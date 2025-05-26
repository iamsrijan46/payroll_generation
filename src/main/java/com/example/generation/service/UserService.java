package com.example.generation.service;

import com.example.generation.dto.LoginRequest;
import com.example.generation.dto.SignupRequest;
import com.example.generation.dto.AuthResponse;

public interface UserService {
    AuthResponse registerUser(SignupRequest request);
    AuthResponse loginUser(LoginRequest request);
}
