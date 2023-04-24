package com.example.manytoone.services;

import com.example.manytoone.entities.StudentHasProgram;
import com.example.manytoone.repos.StudentHasProgramRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class StudentHasProgramService {

    @Autowired
    private StudentHasProgramRepo studentHasProgramRepo;

    //register student with a program
    @Transactional
    public void resisterStudentCourse(int studentId, int programId) {
        LocalDate today = LocalDate.now();
        studentHasProgramRepo.resisterStudentCourse(studentId,programId,today);
    }

}
