package com.example.manytoone.repos;

import com.example.manytoone.entities.StudentHasProgram;
import com.example.manytoone.entities.StudentHasProgramKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;


public interface StudentHasProgramRepo extends JpaRepository<StudentHasProgram, StudentHasProgramKey> {

    //native query to register student to a course
    @Modifying
    @Query(value = "INSERT INTO student_has_program (student_id, program_id, register_date) " +
            "SELECT s.student_id, p.program_id, :today " +
            "FROM student s, program p " +
            "WHERE s.student_id = :studentId AND p.program_id = :programId", nativeQuery = true)
    public void resisterStudentCourse(int studentId, int programId, LocalDate today);

}
