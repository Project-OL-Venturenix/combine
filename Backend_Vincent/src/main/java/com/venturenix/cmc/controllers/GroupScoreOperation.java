package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.entity.GroupScore;
import com.venturenix.cmc.entity.TestCaseScore;
import com.venturenix.cmc.payload.request.GroupScoreRequest;
import com.venturenix.cmc.payload.request.TestCaseScoreRequest;
import jakarta.validation.Valid;

public interface GroupScoreOperation {
  @PostMapping("/groupscores/add")
  ResponseEntity<?> addGroupScore(
      @Valid @RequestBody GroupScoreRequest groupscoreRequest);

  @GetMapping("/groupscores")
  ResponseEntity<List<GroupScore>> getAllGroupScores();

  @GetMapping("/groupscores/{id}")
  ResponseEntity<GroupScore> getGroupScoreById(@PathVariable("id") long id);

  @PutMapping("/groupscores/{id}")
  ResponseEntity<GroupScore> updateGroupScore(@PathVariable("id") long id,
      @RequestBody GroupScore groupscore);

  @DeleteMapping("/groupscores/{id}")
  ResponseEntity<?> deleteGroupScore(@PathVariable("id") long id);

}
