package com.example.manytoone.repos;

import com.example.manytoone.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

//    @Query("select s from Student s")
//    public Page<Student> getAllStudents(Pageable paging);

    //jpql query to load all the students with the pagination option
    @Query("select s from Student s")
    public Page<Student> getAllStudents(org.springframework.data.domain.Pageable paging);
}
