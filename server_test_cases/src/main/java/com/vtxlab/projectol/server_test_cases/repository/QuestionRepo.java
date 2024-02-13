package com.vtxlab.projectol.server_test_cases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.projectol.server_test_cases.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Long>{
  
}
