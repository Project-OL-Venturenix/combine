package com.vtxlab.projectol.backend_oscar.controllers.user;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.TestCase;
import com.vtxlab.projectol.backend_oscar.payload.request.question.TestCaseRequest;
import com.vtxlab.projectol.backend_oscar.payload.response.question.TestCaseDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.question.TestCaseResponse;
import jakarta.validation.Valid;

public interface TestCaseOperation {

  @PostMapping("/testcases/add")
  ResponseEntity<?> addTestCase(
      @Valid @RequestBody TestCaseRequest testcaseRequest);

  @GetMapping("/testcases")
  ResponseEntity<List<TestCaseDTO>> getAllTestCases();

  @GetMapping("/testcases/{id}")
  ResponseEntity<TestCaseResponse> getTestCaseById(@PathVariable String id);

  @PutMapping("/testcases/{id}")
  ResponseEntity<TestCase> updateTestCase(@PathVariable String id,
      @RequestBody TestCase testcase);

  @DeleteMapping("/testcases/{id}")
  ResponseEntity<?> deleteTestCase(@PathVariable String id);
}
