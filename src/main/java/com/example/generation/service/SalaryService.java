package com.example.generation.service;

import com.example.generation.dto.SalaryRequest;
import com.example.generation.dto.SalaryResponse;

public interface SalaryService {
    SalaryResponse generateSalary(SalaryRequest request);
}
