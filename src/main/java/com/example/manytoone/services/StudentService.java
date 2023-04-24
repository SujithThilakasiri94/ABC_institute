package com.example.manytoone.services;

import com.example.manytoone.entities.Student;
import com.example.manytoone.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;



import java.util.Objects;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    //add new student
    public Student addNewStudent(Student student) {
        return studentRepo.save(student);
    }

    //delete a student
    public String deleteStudentById(int id) {
        studentRepo.deleteById(id);
        return ("Student with student ID "+id+" removed from the database successfully");
    }

    //update a student
    public Student updateStudent(Student student, int id) {

        Student studentInDb = studentRepo.findById(id).get();

        if (Objects.nonNull(student.getName())&& !"".equalsIgnoreCase(student.getName())){
            studentInDb.setName(student.getName());
        }
        if (Objects.nonNull(student.getAddress())&& !"".equalsIgnoreCase(student.getAddress())){
            studentInDb.setAddress(student.getAddress());
        }
        if (Objects.nonNull(student.getContact())&& !"".equalsIgnoreCase(student.getContact())){
            studentInDb.setContact(student.getContact());
        }

        return studentRepo.save(studentInDb);
    }

    //Load all the students with the pagination
    public Page<Student> getAllStudents(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return studentRepo.getAllStudents(paging);
    }

    //search a student by Student Id
    public Student getStudentById(int id) {
        return studentRepo.findById(id).get();
    }
}
