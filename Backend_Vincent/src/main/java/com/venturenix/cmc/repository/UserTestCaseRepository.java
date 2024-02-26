package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.UserTestCase;
import java.util.List;

@Repository
public interface UserTestCaseRepository extends JpaRepository<UserTestCase, Long> {

    Optional<UserTestCase> findById(Long id);

    List<UserTestCase> findAll();
    
    

  
}