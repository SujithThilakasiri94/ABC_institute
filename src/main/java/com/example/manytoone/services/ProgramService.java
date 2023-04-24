package com.example.manytoone.services;

import com.example.manytoone.entities.Program;
import com.example.manytoone.repos.ProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepo programRepo;

    //add new program
    public Program addNewProgram(Program program) {
        return programRepo.save(program);
    }

    //delete a program
    public String deleteProgramById(int id) {
        programRepo.deleteById(id);
        return ("Program with program ID "+id+" removed from the database successfully");
    }

    //update a program
    public Program updateProgram(Program program, int id) {

        Program programInDb = programRepo.findById(id).get();

        if (Objects.nonNull(program.getName())&& !"".equalsIgnoreCase(program.getName())){
            programInDb.setName(program.getName());
        }
        if (Objects.nonNull(program.getDuration())&& !"".equalsIgnoreCase(program.getDuration())){
            programInDb.setDuration(program.getDuration());
        }
        if (Objects.nonNull(program.getCost())&& !"".equalsIgnoreCase(program.getCost())){
            programInDb.setCost(program.getCost());
        }

        return programRepo.save(programInDb);
    }

    //load all the programs with pagination
    public Page<Program> getAllPrograms(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return programRepo.getAllPrograms(paging);
    }

    //search a program with the Program Id.
    public Program getProgramById(int id) {
        return programRepo.findById(id).get();
    }
}
