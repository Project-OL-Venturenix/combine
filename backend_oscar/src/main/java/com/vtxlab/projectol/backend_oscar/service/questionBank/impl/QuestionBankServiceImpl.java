package com.vtxlab.projectol.backend_oscar.service.questionBank.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import com.vtxlab.projectol.backend_oscar.payload.response.question.QuestionResponse;
import com.vtxlab.projectol.backend_oscar.repository.questionBank.QuestionBankRepository;
import com.vtxlab.projectol.backend_oscar.service.questionBank.QuestionBankService;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {

  @Autowired
  private QuestionBankRepository questionRepository;

  public static final String CLASS_QUESTION_DECLARATION_TEMPLATE =
      "public class Solution{" + "\n";

  @Override
  public QuestionResponse generateQuestionBank(Long questionId) {

    Optional<QuestionBank> questionBank =
        questionRepository.findById(questionId);
    if (!questionBank.isPresent()) {
      return null;
    }
    return QuestionResponse.builder()//
        .questionId(questionBank.get().getQuestionId())//
        .classDeclaration(CLASS_QUESTION_DECLARATION_TEMPLATE)//
        .code(questionBank.get().getMethodSignatures()
            + this.generateOpenCodeBlock() + "\n" + this.generateEndCodeBlock()
            + "\n" + this.generateEndCodeBlock())//
        .build();
  }

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

  public String generateOpenCodeBlock() {
    return "{";
  }

  public String generateEndCodeBlock() {
    return "}";
  }
}
