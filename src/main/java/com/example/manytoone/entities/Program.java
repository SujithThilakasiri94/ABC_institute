//entity class for program
package com.example.manytoone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "program")
@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id",length = 45)
    private int programId;

    @Column(name = "name",length = 45)
    private String name;

    @Column(name = "duration",length = 45)
    private String duration;

    @Column(name = "cost",length = 45)
    private String cost;

    @OneToMany(mappedBy = "program")
    Set<StudentHasProgram> studentHasProgramSet;

}