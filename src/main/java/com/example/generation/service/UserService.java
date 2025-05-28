package com.example.generation.service;

import com.example.generation.dto.AuthResponse;
import com.example.generation.dto.LoginRequest;
import com.example.generation.dto.SignupRequest;
import com.example.generation.dto.AttendanceSummaryDto;
import com.example.generation.dto.PayrollDto;
import com.example.generation.dto.PayrollRequestDto;
import com.example.generation.dto.UserDto;
import com.example.generation.entity.User; // Make sure to import the User entity

import java.util.List;
import java.util.Optional;

public interface UserService {
    AuthResponse registerUser(SignupRequest request);
    AuthResponse loginUser(LoginRequest request);

    // Existing methods that were likely in your original UserService
    List<UserDto> getAllEmployees(); // This seems to be a specific filter for employees
    AttendanceSummaryDto getAttendanceSummary(Long employeeId);
    PayrollDto generatePayroll(PayrollRequestDto request);

    // NEW: Methods to be added to the interface for fetching all users and user by ID
    List<User> getAllUsers(); // This should return the full User entity list
    Optional<User> getUserById(Long id); // This should return an Optional of the User entity
}