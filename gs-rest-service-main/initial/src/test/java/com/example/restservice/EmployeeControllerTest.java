package com.example.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeManager employeeManager;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetEmployees() throws Exception {
        Employees employees = new Employees();
        employees.setEmployeeList(Arrays.asList(
                new Employee(1, "Flavia", "Dumitrica", "fd@gmail.com", "software developer")
        ));

        when(employeeManager.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeList[0].firstName").value("Flavia"));
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee newEmp = new Employee(null, "F", "D", "fd@example.com", "engineer");

        Employees current = new Employees();
        current.setEmployeeList(Arrays.asList());
        when(employeeManager.getAllEmployees()).thenReturn(current);

        mockMvc.perform(post("/employees/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newEmp)))
        
        
                .andExpect(status().isCreated());
    }

    @Test
    void deleteEmployee_success() throws Exception {
        // Service says the employee existed and was removed
        int idToDelete = 3;
        when(employeeManager.deleteEmployee(idToDelete)).thenReturn(true);

        mockMvc.perform(delete("/employees/{id}", idToDelete))
            .andExpect(status().isNoContent());

        verify(employeeManager).deleteEmployee(idToDelete);
    }

    @Test
    void deleteEmployee_notFound() throws Exception {
        int idToDelete = 99;
        when(employeeManager.deleteEmployee(idToDelete)).thenReturn(false);

        mockMvc.perform(delete("/employees/{id}", idToDelete))
            .andExpect(status().isNotFound());

        verify(employeeManager).deleteEmployee(idToDelete);
    }

}