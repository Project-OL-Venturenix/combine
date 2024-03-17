package com.vtxlab.projectol.backend_oscar.repository.questionBank;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.TestCase;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
  @Query(value = "SELECT * FROM testcases WHERE questionId = ?1", nativeQuery = true)
  List<TestCase> getTestCaseByQuestionId(Long questionId);

}
