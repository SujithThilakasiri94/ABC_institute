//entity class for student
package com.example.manytoone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id",length = 45)
    private int studentId;

    @Column(name = "name",length = 45)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact",length = 45)
    private String contact;

    @OneToMany(mappedBy = "student")
    Set<StudentHasProgram> studentHasProgramSet;

}
