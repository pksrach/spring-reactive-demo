package com.psr.spring_demo_reactive.student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Tag(name = "Student", description = "Student API")
@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @PostMapping
    @Operation(summary = "Create a student", description = "Stores a new student record in the database.")
    public Mono<StudentEntity> create(@RequestBody StudentRequest request) {
        return service.create(request);
    }

    @GetMapping
    @Operation(summary = "Find all students", description = "Fetches all student records.")
    public Flux<StudentEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find student by ID", description = "Fetches a student record by ID.")
    public Mono<StudentEntity> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
