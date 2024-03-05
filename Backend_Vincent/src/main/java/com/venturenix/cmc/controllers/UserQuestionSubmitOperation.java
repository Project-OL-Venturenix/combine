package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.payload.request.UserQuestionSubmitRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import jakarta.validation.Valid;
import com.venturenix.cmc.entity.UserQuestionSubmit;

public interface UserQuestionSubmitOperation {

  @PostMapping("/userquestionsubmits/add")
  ResponseEntity<?> addUserQuestionSubmit(
    @Valid @RequestBody  UserQuestionSubmitRequest userquestionsubmitRequest);

  @GetMapping("/userquestionsubmits")
  ResponseEntity<List<UserQuestionSubmit>> getAllUserQuestionSubmits();

  @GetMapping("/userquestionsubmits/{id}")
  ResponseEntity<UserQuestionSubmit> getUserQuestionSubmitById(
      @PathVariable long id);

  @PutMapping("/userquestionsubmits/{id}")
  ResponseEntity<UserQuestionSubmit> updateUserQuestionSubmit(
      @PathVariable long id,
      @RequestBody UserQuestionSubmit userquestionsubmit);

  @DeleteMapping("/userquestionsubmits/{id}")
  ResponseEntity<?> deleteUserQuestionSubmit(@PathVariable long id);
}
