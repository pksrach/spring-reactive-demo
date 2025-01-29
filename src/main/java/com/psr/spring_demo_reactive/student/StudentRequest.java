package com.psr.spring_demo_reactive.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private int age;

    public static StudentEntity toEntity(StudentRequest request) {
        return new StudentEntity(null, request.getFirstName(), request.getLastName(), request.getAge());
    }

    public StudentEntity toEntity() {
        return new StudentEntity(null, firstName, lastName, age);
    }
}
