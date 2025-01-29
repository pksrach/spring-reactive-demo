package com.psr.spring_demo_reactive.entities;

import com.psr.spring_demo_reactive.infrastructures.entities.BaseEntity;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

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
    private Date dob;
    private String phoneNumber;
    private String card;
}