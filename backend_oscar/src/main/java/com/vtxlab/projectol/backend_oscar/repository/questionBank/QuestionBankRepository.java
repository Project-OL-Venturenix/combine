package com.vtxlab.projectol.backend_oscar.repository.questionBank;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;

@Repository
public interface QuestionBankRepository
    extends JpaRepository<QuestionBank, Long> {
  @Query(
      value = "SELECT testComputeCase FROM questions WHERE questionId = ?1",
      nativeQuery = true)
  String getTestComputeCase(Long questionId);

  @Query(
      value = "SELECT methodSignatures FROM questions WHERE questionId = ?1",
      nativeQuery = true)
  String getMethodSignatures(Long questionId);

  List<QuestionBank> findByEventsId(Long eventId);

}
