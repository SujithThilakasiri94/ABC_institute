//entity class for student_has_program

package com.example.manytoone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "student_has_program")
public class StudentHasProgram {

    //Composite Key
    @EmbeddedId
    private StudentHasProgramKey id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id", nullable = false)
    @MapsId("studentId")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "program_id", nullable = false)
    @MapsId("programId")
    private Program program;

    @Column(nullable = false,length = 45)
    private String registerDate;
}