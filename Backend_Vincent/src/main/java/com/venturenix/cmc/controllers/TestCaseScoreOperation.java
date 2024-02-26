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

import com.venturenix.cmc.entity.TestCaseScore;
import com.venturenix.cmc.payload.request.TestCaseScoreRequest;

public interface TestCaseScoreOperation {
  
  @PostMapping("/testcasescores")
  public ResponseEntity<?> addTestCaseScore(@Valid @RequestBody TestCaseScoreRequest testcasescoreRequest);
  
  @GetMapping("/testcasescores")
  public ResponseEntity<List<TestCaseScore>> getAllTestCaseScores();
  
  @GetMapping("/testcasescores/{id}")
  public ResponseEntity<TestCaseScore> getTestCaseScoreById(@PathVariable("id") long id);
  
  @PutMapping("/testcasescores/{id}")
  public ResponseEntity<TestCaseScore> updateTestCaseScore(@PathVariable("id") long id, @RequestBody TestCaseScore testcasescore);
  
  @DeleteMapping("/testcasescores/{id}")
  public ResponseEntity<?> deleteTestCaseScore(@PathVariable("id") long id);
}
