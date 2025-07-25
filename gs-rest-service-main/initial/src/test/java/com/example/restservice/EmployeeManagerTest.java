 package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeManagerTest {

    private EmployeeManager manager;

    @BeforeEach
    public void setup() {
        manager = new EmployeeManager();
		Employee newEmployee = new Employee(3, "Flavia", "Dumitrica", "fd@gmail.com", "Software developer");
		manager.addEmployee(newEmployee);
    }

	// Helper function to get the number of current employees
	int getEmployeeCount(EmployeeManager manager)
	{
		return manager.getAllEmployees().getEmployeeList().size();
	}

	@Test
	// Ensure that employee list is populated on initialization
	void testCreateEmployeeManager() {
		EmployeeManager newManager = new EmployeeManager();
		assertTrue(getEmployeeCount(newManager) > 0);
	}

	// Ensure that employee ID is in list
	@Test
	void testEmployeeIdInList() {
		assertTrue(
			manager.getAllEmployees()
				.getEmployeeList()
				.stream()
				.anyMatch(e -> e.getId() == 3),
			"Employee with ID 3 should be present in the list");
	}

	// Ensure that employee First Name is in list
	@Test
	void testEmployeeFirstNameInList() {
		assertTrue(
			manager.getAllEmployees()
				.getEmployeeList()
				.stream()
				.anyMatch(e -> e.getFirstName() == "Flavia"),
			"Employee with first name Flavia should be present in the list");
	}

	// Ensure that employee last name is in list
	@Test
	void testEmployeeLastNameInList() {
		assertTrue(
			manager.getAllEmployees()
				.getEmployeeList()
				.stream()
				.anyMatch(e -> e.getLastName() == "Dumitrica"),
			"Employee with last name Dumitrica should be present in the list");
	}

	// Ensure that employee email is in list
	@Test
	void testEmployeeEmailInList() {
		assertTrue(
			manager.getAllEmployees()
				.getEmployeeList()
				.stream()
				.anyMatch(e -> e.getEmail() == "fd@gmail.com"),
			"Employee with email fd@gmail.com should be present in the list");
	}

	// Ensure employee title is in list
	@Test
	void testEmployeeTitleInList() {
		assertTrue(
			manager.getAllEmployees()
				.getEmployeeList()
				.stream()
				.anyMatch(e -> e.getTitle() == "Software developer"),
			"Employee with title Software Developer should be present in the list");
	}
	
}