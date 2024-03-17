package com.vtxlab.projectol.backend_oscar.controllers.group;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.projectol.backend_oscar.entity.group.GroupQuestionSubmit;
import com.vtxlab.projectol.backend_oscar.payload.request.group.GroupQuestionSubmitRequest;
import jakarta.validation.Valid;

public interface GroupQuestionSubmitOperation {
  @PostMapping("/groupquestionsubmits/add")
  public ResponseEntity<?> addGroupQuestionSubmit(
      @Valid @RequestBody GroupQuestionSubmitRequest groupquestionsubmitRequest);

  @GetMapping("/groupquestionsubmits")
  public ResponseEntity<List<GroupQuestionSubmit>> getAllGroupQuestionSubmits();

  @GetMapping("/groupquestionsubmits/{id}")
  public ResponseEntity<GroupQuestionSubmit> getGroupQuestionSubmitById(
      @PathVariable("id") long id);

  @PutMapping("/groupquestionsubmits/{id}")
  public ResponseEntity<GroupQuestionSubmit> updateGroupQuestionSubmit(
      @PathVariable("id") long id,
      @RequestBody GroupQuestionSubmit groupquestionsubmit);

  @DeleteMapping("/groupquestionsubmits/{id}")
  public ResponseEntity<?> deleteGroupQuestionSubmit(
      @PathVariable("id") long id);

}
