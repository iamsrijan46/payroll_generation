package com.example.generation.dto;

public class PayrollDto {
    private String message;
    private Long employeeId;
    private long daysPresent;
    private double totalSalary;

    public PayrollDto(String message, Long employeeId, long daysPresent, double totalSalary) {
        this.message = message;
        this.employeeId = employeeId;
        this.daysPresent = daysPresent;
        this.totalSalary = totalSalary;
    }

    public String getMessage() {
        return message;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public long getDaysPresent() {
        return daysPresent;
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}
