package com.example.generation.controller;

import com.example.generation.dto.AuthResponse;
import com.example.generation.dto.LoginRequest;
import com.example.generation.dto.SignupRequest;
import com.example.generation.dto.AttendanceSummaryDto; // Import DTOs
import com.example.generation.dto.PayrollDto;
import com.example.generation.dto.PayrollRequestDto;
import com.example.generation.dto.UserDto; // Import UserDto
import com.example.generation.entity.User;
import com.example.generation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth") // Base path for AuthController
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

    // Existing endpoint to fetch all users (general)
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Existing endpoint to fetch a single user by ID (general)
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // NEW: Endpoint to fetch all employees (from UserService.getAllEmployees)
    @GetMapping("/employees")
    public ResponseEntity<List<UserDto>> getAllEmployees() {
        List<UserDto> employees = userService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // NEW: Endpoint to get attendance summary for a specific employee
    @GetMapping("/employees/{employeeId}/attendance-summary")
    public ResponseEntity<AttendanceSummaryDto> getAttendanceSummary(@PathVariable Long employeeId) {
        AttendanceSummaryDto summary = userService.getAttendanceSummary(employeeId);
        // You might want to add error handling here if summary is null or employeeId is not found
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    // NEW: Endpoint to generate payroll for an employee
    @PostMapping("/employees/generate-payroll")
    public ResponseEntity<PayrollDto> generatePayroll(@RequestBody PayrollRequestDto request) {
        PayrollDto payroll = userService.generatePayroll(request);
        // You might want to add error handling here if payroll generation fails
        return new ResponseEntity<>(payroll, HttpStatus.OK);
    }
}