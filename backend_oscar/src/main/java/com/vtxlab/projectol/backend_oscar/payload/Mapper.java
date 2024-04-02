package com.vtxlab.projectol.backend_oscar.payload;

import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import com.vtxlab.projectol.backend_oscar.entity.group.Group;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.TestCase;
import com.vtxlab.projectol.backend_oscar.entity.user.User;
import com.vtxlab.projectol.backend_oscar.entity.user.UserScore;
import com.vtxlab.projectol.backend_oscar.payload.response.event.EventDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.group.GroupDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.question.QuestionBankDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.question.TestCaseDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.user.UserDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.user.UserScoreDTO;

public class Mapper {
  public static TestCaseDTO map(TestCase testCase) {
    return TestCaseDTO.builder()
        // .questionId(testCase.getQuestionBank().getQuestionId())//
        .id(testCase.getQuestionBank().getQuestionId())//
        .input1(testCase.getInput1())//
        .input2(testCase.getInput2())//
        .input3(testCase.getInput3())//
        .expectedOutput(testCase.getExpectedOutput())//
        .build();
  }

  public static QuestionBankDTO map(QuestionBank questionBank) {
    return QuestionBankDTO.builder()//
        .questionId(questionBank.getQuestionId())//
        .question(questionBank.getQuestion())//
        .testComputeCase(questionBank.getTestComputeCase())//
        .methodSignatures(questionBank.getMethodSignatures())//
        .bonusRuntime(questionBank.getBonusRuntime())//
        .createdBy(questionBank.getCreatedBy())//
        .createdDate(questionBank.getCreatedDate())//
        .updatedBy(questionBank.getUpdatedBy())//
        .updatedDate(questionBank.getUpdatedDate())//
        .build();
  }

  public static EventDTO map(Event event) {
    return EventDTO.builder()//
        .id(event.getId())//
        .name(event.getName())//
        .status(event.getStatus())//
        .targetStartTime(event.getTargetStartTime())//
        .targetEndTime(event.getTargetEndTime())//
        .eventDate(event.getEventDate())//
        .createdDate(event.getCreatedDate())//
        .createdBy(event.getCreatedBy())//
        .updatedDate(event.getUpdatedDate())//
        .updatedBy(event.getUpdatedBy())//
        .build();

  }

  public static GroupDTO map(Group group) {
    return GroupDTO.builder()//
        .groupsId(group.getGroupsId())//
        .name(group.getName())//
        .status(group.getStatus())//
        .createdDate(group.getCreatedDate())//
        .createdBy(group.getCreatedBy())//
        .updatedDate(group.getUpdatedDate())//
        .updatedBy(group.getUpdatedBy())//
        .build();

  }

  public static UserScoreDTO map(UserScore userScore) {
    return UserScoreDTO.builder()//
        .id(userScore.getId())//
        .submitTime(userScore.getSubmitTime())//
        .resultOfPassingTestecase(userScore.getResultOfPassingTestecase())//
        .bonusUnder30Mins(userScore.getBonusUnder30Mins())//
        .bonusWithinQuestionRuntime(userScore.getBonusWithinQuestionRuntime())//
        .runtimeByMsec(userScore.getRuntimebyMsec())//
        .status(userScore.getStatus())//
        .createdDate(userScore.getCreatedDate())//
        .updatedDate(userScore.getUpdatedDate())//
        .build();

  }

  public static UserDTO map(User user) {
    return UserDTO.builder()//
        .id(user.getId())//
        .firstName(user.getFirstName())//
        .userName(user.getUserName())//
        .email(user.getEmail())//
        .password(user.getPassword())//
        .createdDate(user.getCreatedDate())//
        .createdBy(user.getCreatedBy())//
        .updatedDate(user.getUpdatedDate())//
        .updatedBy(user.getUpdatedBy())//
        .build();
  }
}
