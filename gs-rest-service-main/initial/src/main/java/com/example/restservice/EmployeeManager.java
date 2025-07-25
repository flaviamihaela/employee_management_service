package com.example.restservice;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {

    private static Employees employees = new Employees();

    static {
        // Initialize with sample employees
        employees.getEmployeeList()
          .add(new Employee(1, "Prem", "Tiwari", "prem@gmail.com", "manager"));
        employees.getEmployeeList()
          .add(new Employee(2, "Vikash", "Kumar", "vikash@gmail.com", "graduate"));
        employees.getEmployeeList()
          .add(new Employee(3, "Ritesh", "Ojha", "ritesh@gmail.com", "graduate"));
    }

    // Retrieve all employees
    public Employees getAllEmployees() {
        return employees;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        employees.getEmployeeList().add(employee);
    }

    // Delete an employee
    public boolean deleteEmployee(Integer id) {
    List<Employee> list = employees.getEmployeeList();
    return list.removeIf(e -> Objects.equals(e.getId(), id));
    }
}