package com.jdbcspring.jdbcspring;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    public void insertEmployee(Employee emp);
    public void updateEmployee(Employee emp);
    public void executeUpdateEmployee(Employee emp);
    public void deleteEmployee(Employee emp);
}