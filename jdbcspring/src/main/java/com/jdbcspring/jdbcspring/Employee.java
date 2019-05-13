package com.jdbcspring.jdbcspring;


import java.util.Objects;

public class Employee {

    private String employeeName;
    private int employeeId;
    private String employeeAddress;
    private String employeeEmail;

    public Employee(){}

    public Employee(String employeeName, int employeeId, String employeeAddress, String employeeEmail) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.employeeAddress = employeeAddress;
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                Objects.equals(employeeName, employee.employeeName) &&
                Objects.equals(employeeAddress, employee.employeeAddress) &&
                Objects.equals(employeeEmail, employee.employeeEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeName, employeeId, employeeAddress, employeeEmail);
    }
}
