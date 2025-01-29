package com.psr.spring_demo_reactive.student;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<StudentEntity, Integer> {
    Flux<StudentEntity> findAllByFirstNameIgnoreCase(String firstName);
}
