package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.entity.TestCase;
import com.venturenix.cmc.payload.request.TestCaseRequest;
import com.venturenix.cmc.payload.response.TestCaseResponse;
import jakarta.validation.Valid;

public interface TestCaseOperation {
  @PostMapping("/testcases/add")
  ResponseEntity<?> addTestCase(
      @Valid @RequestBody TestCaseRequest testcaseRequest);

  @GetMapping("/testcases")
  ResponseEntity<List<TestCase>> getAllTestCases();

  @GetMapping("/testcases/{id}")
  ResponseEntity<TestCaseResponse> getTestCaseById(@PathVariable String id);

  @PutMapping("/testcases/{id}")
  ResponseEntity<TestCase> updateTestCase(@PathVariable long id,
      @RequestBody TestCase testcase);

  @DeleteMapping("/testcases/{id}")
  ResponseEntity<?> deleteTestCase(@PathVariable long id);
}
