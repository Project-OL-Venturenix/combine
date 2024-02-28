package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.payload.request.GroupUserQuestionHandleRequest;
import com.venturenix.cmc.entity.GroupUserQuestionHandle;
import com.venturenix.cmc.payload.response.MessageResponse;
import jakarta.validation.Valid;

public interface GroupUserQuestionHandleOperation {
  @PostMapping("/groupuserquestionhandle/add")
  ResponseEntity<?> addGroupUserQuestionHandle(
      @Valid @RequestBody GroupUserQuestionHandleRequest groupuserquestionhandleRequest);

  @GetMapping("/groupuserquestionhandles")
  ResponseEntity<List<GroupUserQuestionHandle>> getAllGroupUserQuestionHandles();

  @GetMapping("/groupuserquestionhandle/{id}")
  ResponseEntity<GroupUserQuestionHandle> getGroupUserQuestionHandleById(
      @PathVariable long id);

  @PutMapping("/groupuserquestionhandle/{id}")
  ResponseEntity<GroupUserQuestionHandle> updateGroupUserQuestionHandle(
      @PathVariable long id,
      @RequestBody GroupUserQuestionHandle groupuserquestionhandle);

  @DeleteMapping("/groupuserquestionhandle/{id}")
  ResponseEntity<?> deleteGroupUserQuestionHandle(@PathVariable long id);
}