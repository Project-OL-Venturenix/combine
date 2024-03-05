package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.entity.EventQuestion;
import com.venturenix.cmc.payload.request.EventQuestionRequest;
import jakarta.validation.Valid;

public interface EventQuestionOperation {
  @PostMapping("/eventquestions/add")
  public ResponseEntity<?> addEventQuestion(
      @Valid @RequestBody EventQuestionRequest eventQuestionRequest);

  @GetMapping("/eventquestions")
  public ResponseEntity<List<EventQuestion>> getAllEventQuestions();

  @GetMapping("/eventquestions/{id}")
  public ResponseEntity<EventQuestion> getEventQuestionById(
      @PathVariable("id") long id);

  @PutMapping("/eventquestions/{id}")
  public ResponseEntity<EventQuestion> updateEventQuestion(
      @PathVariable("id") long id, @RequestBody EventQuestion eventQuestion);

  @DeleteMapping("/eventquestions/{id}")
  public ResponseEntity<?> deleteEventQuestion(@PathVariable("id") long id);
}
