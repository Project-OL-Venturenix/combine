package com.venturenix.cmc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.TestCase;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
  @Query(value = "SELECT * FROM testcases WHERE question_id = ?1", nativeQuery = true)
  List<TestCase> getTestCaseByQuestionId(Long questionId);

}
