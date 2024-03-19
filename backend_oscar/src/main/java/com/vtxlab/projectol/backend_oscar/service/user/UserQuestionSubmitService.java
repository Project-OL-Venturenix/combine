package com.vtxlab.projectol.backend_oscar.service.user;

import java.util.List;
import com.vtxlab.projectol.backend_oscar.entity.user.UserScore;
import com.vtxlab.projectol.backend_oscar.payload.request.user.UserQuestionSubmitRequest;

public interface UserQuestionSubmitService {

  void addUserQuestionSubmit(
      UserQuestionSubmitRequest userquestionsubmitRequest);

  List<UserScore> getAllUserQuestionSubmits();

  UserScore getUserQuestionSubmitById(long id);

  UserScore updateUserQuestionSubmit(long id, UserScore userquestionsubmit);

  void deleteUserQuestionSubmit(long id);
}
