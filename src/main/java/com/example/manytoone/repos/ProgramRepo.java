package com.example.manytoone.repos;

import com.example.manytoone.entities.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProgramRepo extends JpaRepository<Program,Integer> {

    //jpql query to load all the programs with the pagination option
    @Query("select p from Program p")
    public Page<Program> getAllPrograms(org.springframework.data.domain.Pageable paging);
}
