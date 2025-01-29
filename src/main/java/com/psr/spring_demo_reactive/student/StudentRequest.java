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

    public StudentEntity toEntity() {
        return new StudentEntity(null, firstName, lastName, age);
    }
}
