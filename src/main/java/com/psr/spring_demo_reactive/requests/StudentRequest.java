package com.psr.spring_demo_reactive.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.psr.spring_demo_reactive.deserialize.DateDeserializer;
import com.psr.spring_demo_reactive.entities.StudentEntity;
import com.psr.spring_demo_reactive.enumeration.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @NotBlank(message = "First name is mandatory")
    private String lastName;
    @NotNull(message = "Gender is mandatory")
    private Gender gender;
    @Past(message = "Date of birth must be in the past")
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDate dob;
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    private String phoneNumber;
    private String card;

    public StudentEntity toEntity() {
        return new StudentEntity(firstName, lastName, gender.ordinal(), dob, phoneNumber, card);
    }
}
