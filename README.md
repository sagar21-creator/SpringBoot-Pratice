Spring Boot REST API Example

This repository demonstrates how to build robust RESTful APIs using Spring Boot. It integrates core technologies like Spring Web, Spring Data JPA (Hibernate), Bean Validation, MySQL, and DTO mapping (ModelMapper/MapStruct).

Designed for beginners and intermediate developers, it follows clean architecture principles for production-ready REST services.

🚀 Features

✅ Modern REST API design with Spring Boot controllers

✅ Data persistence using JPA (Hibernate) & MySQL

✅ Entity-to-DTO mapping with ModelMapper or MapStruct

✅ Request validation using Jakarta Bean Validation

✅ Clean Controller → Service → Repository architecture

✅ Full CRUD operations

✅ Centralized exception & error handling

🛠️ Getting Started
Prerequisites

Java 17+

Maven/Gradle

MySQL instance (local/remote)

Installation

Clone the repository

git clone https://github.com/youruser/spring-rest-api-example.git
cd spring-rest-api-example


Configure Database
Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/demo_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update


Build & Run

./mvnw spring-boot:run

📂 Project Structure
Layer	Package	Description
Controller	controller	REST endpoints (@RestController)
Service	service	Business logic & transactions
Repository	repository	Spring Data JPA interfaces
Model	model	Entities mapped to database tables
DTO	dto	Data transfer objects
Mapper	mapper	ModelMapper/MapStruct config
📖 Example Usage
Controller
@RestController
@RequestMapping("/api/books")
@Validated
public class BookController {
    @PostMapping
    public ResponseEntity<BookDto> create(@Valid @RequestBody BookDto dto) { ... }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> get(@PathVariable Long id) { ... }
}

Entity
@Entity
public class Book {
    @Id @GeneratedValue
    private Long id;

    @NotBlank
    private String title;
}

DTO
public class BookDto {
    private Long id;

    @NotBlank
    private String title;
}

ModelMapper Config
@Bean
public ModelMapper modelMapper() {
    return new ModelMapper();
}

🔗 API Endpoints
Method	Endpoint	Description
POST	/api/books	Create a book
GET	/api/books/{id}	Get book by ID
PUT	/api/books/{id}	Update a book
DELETE	/api/books/{id}	Delete a book
✅ Validation & Error Handling

Request payloads use Jakarta Bean Validation (@NotNull, @NotBlank, etc).

Invalid requests return 400 Bad Request with clear error messages.

📜 License

This project is licensed under the MIT License.
