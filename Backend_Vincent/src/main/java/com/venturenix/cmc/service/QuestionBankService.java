package com.venturenix.cmc.service;

import com.venturenix.cmc.entity.QuestionBank;
import com.venturenix.cmc.payload.request.QuestionRequest;

public interface QuestionBankService {

  String getTestComputeCase(Long questionId);

  String getMethodSignatures(Long questionId);

  boolean save(QuestionBank questionBank);
}
