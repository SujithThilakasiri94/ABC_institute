package com.example.manytoone.controller;

import com.example.manytoone.entities.Program;
import com.example.manytoone.entities.Student;
import com.example.manytoone.services.ProgramService;
import com.example.manytoone.services.StudentHasProgramService;
import com.example.manytoone.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("many-to-one/api/v1")
public class AllControllers {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProgramService programService;

    @Autowired
    private StudentHasProgramService studentHasProgramService;

    //add new student
    @PostMapping("add-new-student")
    public Student addNewStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    //add new program
    @PostMapping("add-new-program")
    public Program addNewProgram(@RequestBody Program program){
        return programService.addNewProgram(program);
    }

    //delete student
    @DeleteMapping("delete-student/{id}")
    public String deleteStudentById(@PathVariable int id){
      return studentService.deleteStudentById(id);
    }

    //delete program
    @DeleteMapping("delete-program/{id}")
    public String deleteProgramById(@PathVariable int id){
        return programService.deleteProgramById(id);
    }

    //update student
    @PutMapping("update-student/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable int id){
        return studentService.updateStudent(student,id);
    }

    //update program
    @PutMapping("update-program/{id}")
    public Program updateProgram(@RequestBody Program program,@PathVariable int id){
        return programService.updateProgram(program,id);
    }

    //get students with pagination
    @GetMapping("/get-all-students")
    public Page<Student> getAllStudents(@RequestParam(defaultValue = "0") Integer pageNo,
                                     @RequestParam(defaultValue = "5") Integer pageSize,
                                     @RequestParam(defaultValue = "id") String sortBy) {
        return studentService.getAllStudents(pageNo, pageSize);
    }

    //get programs with pagination
    @GetMapping("/get-all-programs")
    public Page<Program> getAllPrograms(@RequestParam(defaultValue = "0") Integer pageNo,
                                     @RequestParam(defaultValue = "5") Integer pageSize,
                                     @RequestParam(defaultValue = "id") String sortBy) {
        return programService.getAllPrograms(pageNo, pageSize);
    }

    //register a student with a program
    @PostMapping("register-student-course/{studentId}/programs/{programId}")
    public void resisterStudentCourse(@PathVariable int studentId,@PathVariable int programId){
        studentHasProgramService.resisterStudentCourse(studentId,programId);
    }

    //search a student using student id
    @GetMapping("get-student/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    //search a program using program id
    @GetMapping("get-program/{id}")
    public Program getProgramById(@PathVariable int id){
        return programService.getProgramById(id);
    }
}
