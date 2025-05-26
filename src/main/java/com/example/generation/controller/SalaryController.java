package com.example.generation.controller;

import com.example.generation.dto.SalaryRequest;
import com.example.generation.dto.SalaryResponse;
import com.example.generation.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/generate")
    public SalaryResponse generateSalary(@RequestBody SalaryRequest request) {
        return salaryService.generateSalary(request);
    }
}
