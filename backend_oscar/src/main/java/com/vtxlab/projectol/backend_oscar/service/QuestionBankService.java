package com.vtxlab.projectol.backend_oscar.service;

import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;

public interface QuestionBankService {

  String getTestComputeCase(Long questionId);

  String getMethodSignatures(Long questionId);

  boolean save(QuestionBank questionBank);
}
