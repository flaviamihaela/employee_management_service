# Employee Management RESTful Web Service

## Overview

This project is a RESTful web service for managing a list of employees, built with Java Spring Boot. It provides endpoints to create, retrieve, update, and delete employee records, each containing fields such as first name, last name, employee ID, email, and title. The service is designed for deployment on a private cloud server and is suitable for integration with the GreenLake Cloud Platform.

## Key Features

- **RESTful API**: Supports standard HTTP methods (GET, POST, PUT, DELETE) for employee management.
- **CRUD Operations**: Create, read, update, and delete employee records.
- **JSON Support**: Accepts and returns data in JSON format.
- **Spring Boot**: Leverages Spring Boot for rapid development, embedded server, and easy deployment.
- **Unit Testing**: Includes a suite of unit tests to ensure reliability and correctness.
- **Cloud Ready**: Designed for deployment on private cloud infrastructure.

## Dependencies

- **Java 8 or higher**
- **Spring Boot** (version as specified in `build.gradle` or `pom.xml`)
- **Gradle** or **Maven** (for build management)
- **JUnit** (for testing)
- (Optional) **GreenLake Cloud Platform SDK** if integrating with HPE GreenLake

## Build and Run

### Using Gradle (although I personally didn"t use it)

```sh
# Navigate to the project directory
cd gs-rest-service-main/gs-rest-service-main/complete

# Build the project
./gradlew build

# Run the application
./gradlew bootRun
```

### Using Maven

```sh
# Navigate to the project directory
cd gs-rest-service-main/gs-rest-service-main/complete

# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080` by default.

## Usage

### API Endpoints

- `GET /employees` — Retrieve the full list of employees.
- `POST /employees` — Add a new employee (provide JSON body).
- `PUT /employees/{employee_id}` — Update an existing employee.
- `DELETE /employees/{employee_id}` — Delete an employee by ID.

### Example Employee JSON

```json
{
  "first_name": "Flavia",
  "last_name": "Dumitrica",
  "employee_id": "12345",
  "email": "fd@example.com",
  "title": "Software Engineer"
}
```

### Parameters to Tune

- **Server Port**: Change the default port by editing `src/main/resources/application.properties`:
  ```
  server.port=8080
  ```
- **Logging Level**: Adjust logging verbosity in `application.properties`:
  ```
  logging.level.org.springframework=INFO
  ```
