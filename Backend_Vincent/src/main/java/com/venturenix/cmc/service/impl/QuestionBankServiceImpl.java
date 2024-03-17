package com.venturenix.cmc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.venturenix.cmc.entity.questionBank.QuestionBank;
import com.venturenix.cmc.repository.questionBank.QuestionBankRepository;
import com.venturenix.cmc.service.QuestionBankService;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {

  @Autowired
  private QuestionBankRepository questionRepository;

  @Override
  public String getTestComputeCase(Long questionId) {
    return questionRepository.getTestComputeCase(questionId);
  }

  @Override
  public String getMethodSignatures(Long questionId) {
    return questionRepository.getMethodSignatures(questionId);
  }

  @Override
  public boolean save(QuestionBank questionBank) {
    questionRepository.save(questionBank);
    return true;
  }
}
