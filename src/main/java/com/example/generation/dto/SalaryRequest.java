package com.example.generation.dto;

public class SalaryRequest {
    private Long employeeId;
    private double basePay;

    public SalaryRequest() {}

    public SalaryRequest(Long employeeId, double basePay) {
        this.employeeId = employeeId;
        this.basePay = basePay;
    }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public double getBasePay() { return basePay; }
    public void setBasePay(double basePay) { this.basePay = basePay; }
}
