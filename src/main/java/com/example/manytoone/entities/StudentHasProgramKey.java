package com.example.manytoone.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Embeddable
public class StudentHasProgramKey implements Serializable {

    @Column(name = "student_id",length = 45)
    private int studentStudentId;

    @Column(name = "program_id",length = 45)
    private int programProgramId;
}
