package com.example.generation.serviceImpl;

import com.example.generation.dto.AuthResponse;
import com.example.generation.dto.LoginRequest;
import com.example.generation.dto.SignupRequest;
import com.example.generation.entity.User;
import com.example.generation.repository.UserRepository;
import com.example.generation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse registerUser(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return new AuthResponse("Username is already taken!");
        }

        User user = new User(
                request.getUsername(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())
        );

        userRepository.save(user);
        return new AuthResponse("User registered successfully!");
    }

    @Override
    public AuthResponse loginUser(LoginRequest request) {
        Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());

        if (optionalUser.isEmpty()) {
            return new AuthResponse("Invalid username or password");
        }

        User user = optionalUser.get();
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthResponse("Invalid username or password");
        }

        return new AuthResponse("Login successful");
    }
}
