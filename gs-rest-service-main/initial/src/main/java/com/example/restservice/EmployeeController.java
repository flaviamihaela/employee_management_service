package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// REST Controller for managing employees
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    // GET endpoint to fetch all employees
    @GetMapping(path = "/", produces = "application/json")
    public Employees getEmployees() {
        return employeeManager.getAllEmployees();
    }

    // POST endpoint to add a new employee
    @PostMapping(path = "/", produces = "application/json", consumes = "application/json" )
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
      
        // Generate ID for the new employee
        employeeManager.addEmployee(employee);

        // Build location URI for the new employee
        URI location = ServletUriComponentsBuilder
                          .fromCurrentRequest()
                          .path("/{id}")
                          .buildAndExpand(employee.getId())
                          .toUri();

        return ResponseEntity.created(location).build();
    }

    // DELETE endpoint to delete an existing employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {

        boolean removed = employeeManager.deleteEmployee(id);
        return removed
                ? ResponseEntity.noContent().build()  // 204
                : ResponseEntity.notFound().build(); //404
    }
}