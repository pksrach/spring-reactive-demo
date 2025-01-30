package com.psr.spring_demo_reactive.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "base_entity")
public abstract class BaseEntity {
    @Id
    private Integer id;

    @CreatedDate
    private LocalDateTime createdDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime deletedDate;

    @LastModifiedBy
    private String deletedBy;
}
