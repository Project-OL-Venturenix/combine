package com.venturenix.cmc.repository.questionBank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.questionBank.QuestionBank;

@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBank, Long> {
  @Query(
      value = "SELECT testComputeCase FROM questionbank WHERE questionId = ?1",
      nativeQuery = true)
  String getTestComputeCase(Long questionId);

  @Query(
      value = "SELECT methodSignatures FROM questionbank WHERE questionId = ?1",
      nativeQuery = true)
  String getMethodSignatures(Long questionId);
}
