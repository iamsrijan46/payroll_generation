package com.example.generation.serviceImpl;

import com.example.generation.dto.SalaryRequest;
import com.example.generation.dto.SalaryResponse;
import com.example.generation.entity.User;
import com.example.generation.repository.UserRepository;
import com.example.generation.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public SalaryResponse generateSalary(SalaryRequest request) {
        Optional<User> userOpt = userRepository.findById(request.getEmployeeId());

        if (userOpt.isEmpty()) {
            return new SalaryResponse(null, 0, "Employee not found.");
        }

        double salary = request.getBasePay(); // Extendable with bonuses/deductions

        return new SalaryResponse(request.getEmployeeId(), salary, "Salary generated successfully.");
    }
}
