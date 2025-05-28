//package com.example.generation.controller;
//
//import com.example.generation.dto.AttendanceSummaryDto;
//import com.example.generation.dto.PayrollDto;
//import com.example.generation.dto.PayrollRequestDto;
//import com.example.generation.dto.UserDto;
//import com.example.generation.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/employees")
//@CrossOrigin(origins = "http://localhost:4200") // Allow Angular frontend
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    // ✅ List all employees (admin view)
//    @GetMapping
//    public ResponseEntity<List<UserDto>> getAllEmployees() {
//        return ResponseEntity.ok(userService.getAllEmployees());
//    }
//
//    // ✅ Get attendance summary of a specific employee by ID
//    @GetMapping("/{id}/attendance-summary")
//    public ResponseEntity<AttendanceSummaryDto> getEmployeeSummary(@PathVariable Long id) {
//        return ResponseEntity.ok(userService.getAttendanceSummary(id));
//    }
//
//    // ✅ Generate payroll for an employee
//    @PostMapping("/generate-payroll")
//    public ResponseEntity<PayrollDto> generatePayroll(@RequestBody PayrollRequestDto request) {
//        return ResponseEntity.ok(userService.generatePayroll(request));
//    }
//}
