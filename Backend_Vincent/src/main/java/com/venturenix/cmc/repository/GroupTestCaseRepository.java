package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.venturenix.cmc.models.GroupTestCase;
import java.util.List;

@Repository
public interface GroupTestCaseRepository extends JpaRepository<GroupTestCase, Long> {

    Optional<GroupTestCase> findById(int id);

    

    List<GroupTestCase> findAll();
    
    

  
}