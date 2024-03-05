package com.venturenix.cmc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.venturenix.cmc.entity.GroupTestCase;
import com.venturenix.cmc.payload.request.GroupTestCaseRequest;
import com.venturenix.cmc.payload.response.MessageResponse;

import jakarta.validation.Valid;

public interface GroupTestCaseOperation {
  
  @PostMapping("/grouptestcases/add")
  public ResponseEntity<?> addGroupTestCase(@Valid @RequestBody GroupTestCaseRequest grouptestcaseRequest);

  @GetMapping("/grouptestcases")
  public ResponseEntity<List<GroupTestCase>> getAllGroupTestCases();

  @GetMapping("/grouptestcases/{id}")
  public ResponseEntity<GroupTestCase> getGroupTestCaseById(@PathVariable("id") long id);

  @PutMapping("/grouptestcases/{id}")
  public ResponseEntity<GroupTestCase> updateGroupTestCase(@PathVariable("id") long id, @RequestBody GroupTestCase grouptestcase);

  @DeleteMapping("/grouptestcases/{id}")
  public ResponseEntity<?> deleteGroupTestCase(@PathVariable("id") long id);
}
