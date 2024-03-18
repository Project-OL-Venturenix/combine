package com.vtxlab.projectol.backend_oscar.service.questionBank.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import com.vtxlab.projectol.backend_oscar.repository.questionBank.QuestionBankRepository;
import com.vtxlab.projectol.backend_oscar.service.questionBank.QuestionBankService;

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
