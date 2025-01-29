package com.psr.spring_demo_reactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Mono<StudentEntity> create(StudentRequest request) {
//      or StudentEntity entity = StudentRequest.toEntity(request);

        return repository.save(request.toEntity());
//      or return repository.save(entity);
    }

    public Flux<StudentEntity> findAll() {
        return repository.findAll();
    }

    public Mono<StudentEntity> findById(Integer id) {
        return repository.findById(id);
    }
}
