package com.psr.spring_demo_reactive.repositories;


import com.psr.spring_demo_reactive.entities.StudentEntity;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends BaseRepository<StudentEntity, Integer> {
    Flux<StudentEntity> findAllByFirstNameIgnoreCase(String firstName);
}
