package com.psr.spring_demo_reactive.responses;

import com.psr.spring_demo_reactive.entities.StudentEntity;
import com.psr.spring_demo_reactive.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dob;
    private String phoneNumber;
    private String card;


    public static Mono<StudentResponse> fromEntity(StudentEntity entity) {
        return Mono.just(new StudentResponse(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                Gender.fromOrdinal(entity.getGender()),
                entity.getDob(),
                entity.getPhoneNumber(),
                entity.getCard()
        ));
    }

    public static Mono<StudentResponse> fromEntity(Mono<StudentEntity> entity) {
        return entity.flatMap(StudentResponse::fromEntity);
    }

    public static Flux<StudentResponse> fromEntities(Flux<StudentEntity> entities) {
        return entities.flatMap(StudentResponse::fromEntity);
    }
}
