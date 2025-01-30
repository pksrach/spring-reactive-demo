package com.psr.spring_demo_reactive.controllers;

import com.psr.spring_demo_reactive.requests.StudentRequest;
import com.psr.spring_demo_reactive.responses.StudentResponse;
import com.psr.spring_demo_reactive.servies.StudentService;
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
    public Mono<StudentResponse> create(@RequestBody StudentRequest request) {
        return StudentResponse.fromEntity(service.create(request.toEntity()));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a student", description = "Updates an existing student record in the database.")
    public Mono<StudentResponse> update(@PathVariable Integer id, @RequestBody StudentRequest request) {
        var data = service.update(id, request.toEntity());
        return StudentResponse.fromEntity(data);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a student", description = "Deletes a student record from the database.")
    public Mono<Void> delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping
    @Operation(summary = "Find all students", description = "Fetches all student records.")
    public Flux<StudentResponse> findAll() {
        return StudentResponse.fromEntities(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find student by ID", description = "Fetches a student record by ID.")
    public Mono<StudentResponse> findById(@PathVariable Integer id) {
        var data = service.findById(id);
        return StudentResponse.fromEntity(data);
    }
}
