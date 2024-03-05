package com.venturenix.cmc.controllers;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.venturenix.cmc.payload.request.UserTestCaseRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.entity.UserTestCase;

public interface UserTestCaseOperation {
  
  @PostMapping("/usertestcases/add")
  public ResponseEntity<?> addUserTestCase(@Valid @RequestBody UserTestCaseRequest usertestcaseRequest);

  @GetMapping("/usertestcases")
  public ResponseEntity<List<UserTestCase>> getAllUserTestCases();

  @GetMapping("/usertestcases/{id}")
  public ResponseEntity<UserTestCase> getUserTestCaseById(@PathVariable("id") long id);

  @PutMapping("/usertestcases/{id}")
  public ResponseEntity<UserTestCase> updateUserTestCase(@PathVariable("id") long id, @RequestBody UserTestCase usertestcase);

  @DeleteMapping("/usertestcases/{id}")
  public ResponseEntity<?> deleteUserTestCase(@PathVariable("id") long id);
}
