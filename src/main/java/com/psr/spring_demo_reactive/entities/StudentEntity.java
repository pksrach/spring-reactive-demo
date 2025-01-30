package com.psr.spring_demo_reactive.entities;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "students")
public class StudentEntity extends BaseEntity {
    private String firstName;
    private String lastName;
    private int gender;
    private LocalDate dob;
    private String phoneNumber;
    private String card;
}