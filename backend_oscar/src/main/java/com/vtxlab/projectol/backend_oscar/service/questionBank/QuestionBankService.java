package com.vtxlab.projectol.backend_oscar.service.questionBank;

import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import com.vtxlab.projectol.backend_oscar.payload.response.question.QuestionResponse;

public interface QuestionBankService {

  String getTestComputeCase(Long questionId);

  String getMethodSignatures(Long questionId);

  boolean save(QuestionBank questionBank);

  QuestionResponse generateQuestionBank(Long questionId);
}
