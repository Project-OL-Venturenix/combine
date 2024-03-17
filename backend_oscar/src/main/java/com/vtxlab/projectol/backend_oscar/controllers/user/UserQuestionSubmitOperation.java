package com.vtxlab.projectol.backend_oscar.controllers.user;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.projectol.backend_oscar.entity.user.UserScore;
import com.vtxlab.projectol.backend_oscar.payload.request.user.UserQuestionSubmitRequest;
import jakarta.validation.Valid;

public interface UserQuestionSubmitOperation {

  @PostMapping("/userquestionsubmits/add")
  ResponseEntity<?> addUserQuestionSubmit(
    @Valid @RequestBody  UserQuestionSubmitRequest userquestionsubmitRequest);

  @GetMapping("/userquestionsubmits")
  ResponseEntity<List<UserScore>> getAllUserQuestionSubmits();

  @GetMapping("/userquestionsubmits/{id}")
  ResponseEntity<UserScore> getUserQuestionSubmitById(
      @PathVariable long id);

  @PutMapping("/userquestionsubmits/{id}")
  ResponseEntity<UserScore> updateUserQuestionSubmit(
      @PathVariable long id,
      @RequestBody UserScore userquestionsubmit);

  @DeleteMapping("/userquestionsubmits/{id}")
  ResponseEntity<?> deleteUserQuestionSubmit(@PathVariable long id);
}
