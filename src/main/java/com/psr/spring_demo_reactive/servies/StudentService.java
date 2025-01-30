package com.psr.spring_demo_reactive.servies;

import com.psr.spring_demo_reactive.entities.StudentEntity;
import com.psr.spring_demo_reactive.repositories.StudentRepository;
import com.psr.spring_demo_reactive.requests.StudentRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StudentService extends BaseService<StudentEntity, Integer> {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Mono<StudentEntity> create(StudentRequest request) {
        return super.create(request.toEntity());
    }

    @Override
    protected void updateEntity(StudentEntity existingEntity, StudentEntity newEntity) {
        existingEntity.setFirstName(newEntity.getFirstName());
        existingEntity.setLastName(newEntity.getLastName());
        existingEntity.setGender(newEntity.getGender());
        existingEntity.setDob(newEntity.getDob());
        existingEntity.setPhoneNumber(newEntity.getPhoneNumber());
        existingEntity.setCard(newEntity.getCard());
    }
}
