package com.example.generation.dto;

public class SalaryResponse {
    private Long employeeId;
    private double monthlySalary;
    private String message;

    public SalaryResponse() {}

    public SalaryResponse(Long employeeId, double monthlySalary, String message) {
        this.employeeId = employeeId;
        this.monthlySalary = monthlySalary;
        this.message = message;
    }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
