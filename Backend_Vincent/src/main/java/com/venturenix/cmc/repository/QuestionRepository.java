package com.venturenix.cmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.QuestionBank;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionBank, Long> {
  @Query(
      value = "SELECT test_compute_case FROM question_bank WHERE question_id = ?1",
      nativeQuery = true)
  String getTestComputeCase(Long questionId);

  @Query(
      value = "SELECT method_signatures FROM question_bank WHERE question_id = ?1",
      nativeQuery = true)
  String getMethodSignatures(Long questionId);
}
