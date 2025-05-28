package com.example.generation.serviceImpl;

import com.example.generation.dto.*;
import com.example.generation.entity.Role;
import com.example.generation.entity.User;
import com.example.generation.repository.AttendanceRepository;
import com.example.generation.repository.UserRepository;
import com.example.generation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.generation.entity.Attendance; // Ensure this import is correct

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse registerUser(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return new AuthResponse("Username is already taken!");
        }

        Role role;
        try {
            role = Role.valueOf(request.getRole().toUpperCase());
        } catch (Exception e) {
            return new AuthResponse("Invalid role specified!");
        }

        User user = new User(
                request.getUsername(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                role
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

        return new AuthResponse("Login successful", user.getRole().name());
    }

    @Override
    public List<UserDto> getAllEmployees() {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole() == Role.EMPLOYEE)
                .map(user -> new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getRole().name()))
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceSummaryDto getAttendanceSummary(Long employeeId) {
        List<Attendance> records = attendanceRepository.findByUserId(employeeId);

        long present = records.stream().filter(a -> "PRESENT".equalsIgnoreCase(a.getStatus())).count();
        long absent = records.stream().filter(a -> "ABSENT".equalsIgnoreCase(a.getStatus())).count();
        long holiday = records.stream().filter(a -> "HOLIDAY".equalsIgnoreCase(a.getStatus())).count();

        return new AttendanceSummaryDto(present, absent, holiday);
    }

    @Override
    public PayrollDto generatePayroll(PayrollRequestDto request) {
        AttendanceSummaryDto summary = getAttendanceSummary(request.getEmployeeId());
        double totalSalary = summary.getPresent() * request.getBasePay();

        return new PayrollDto("Payroll generated", request.getEmployeeId(), summary.getPresent(), totalSalary);
    }

    // NEW: Implement the methods from UserService interface
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}