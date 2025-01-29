package com.psr.spring_demo_reactive.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.psr.spring_demo_reactive.deserialize.DateDeserializer;
import com.psr.spring_demo_reactive.entities.StudentEntity;
import com.psr.spring_demo_reactive.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private Gender gender;
    @JsonDeserialize(using = DateDeserializer.class)
    private Date dob;
    private String phoneNumber;
    private String card;

    public StudentEntity toEntity() {
        return new StudentEntity(firstName, lastName, gender.ordinal(), dob, phoneNumber, card);
    }
}
