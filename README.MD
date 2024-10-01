
```markdown
# Note Collector API

This is a Note Collector API built using the **Spring Framework**. It serves as a backend system for managing notes and provides an organized structure with layers such as DTO, Controller, Service, Entity, Config, and more. The server runs on **Tomcat**.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [License](#license)

## Features

- Create, read, update, and delete (CRUD) notes.
- API designed following REST principles.
- Custom error handling using exceptions.
- Modular structure for maintainability.

## Tech Stack

- **Java**
- **Spring Boot**
- **Tomcat Server**
- **MySQL** (or any preferred database)

## Project Structure

## Project Structure

```bash
/src
│
├── /config         # Configuration classes for Spring Beans, Security, etc.
├── /controller     # REST Controllers to handle incoming requests
├── /dto            # Data Transfer Objects to encapsulate request/response
├── /entity         # JPA Entities mapped to the database
├── /exception      # Custom exception handling and error responses
├── /service        # Service classes that hold business logic
├── /util           # Utility classes for common functionality
└── /AppInit.java   # Main class to launch the Spring Boot application


## Getting Started

### Prerequisites

- **Java 17+**
- **Maven** or **Gradle** for dependency management.
- A database such as **MySQL**.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/ChathuminiBandara/NoteCollector.git
   ```

2. Navigate to the project directory:

   ```bash
   cd note-collector-api
   ```

3. Configure the database connection in `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/note_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```

4. Build and run the application:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. The API will run at `http://localhost:8080`.

## API Endpoints

| Method | Endpoint            | Description              |
|--------|---------------------|--------------------------|
| GET    | `/api/notes`         | Retrieve all notes       |
| POST   | `/api/notes`         | Create a new note        |
| GET    | `/api/notes/{id}`    | Get a note by ID         |
| PUT    | `/api/notes/{id}`    | Update a note by ID      |
| DELETE | `/api/notes/{id}`    | Delete a note by ID      |

## Custom Status Codes

- **201**: Resource created successfully.
- **204**: Resource deleted successfully.
- **400**: Bad request or validation error.
- **404**: Resource not found.
- **500**: Internal server error.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

