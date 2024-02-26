package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.TestCaseScore;
import java.util.List;

@Repository
public interface TestCaseScoreRepository extends JpaRepository<TestCaseScore, Long> {

    Optional<TestCaseScore> findById(Long id);

    List<TestCaseScore> findAll();
    
    

  
}