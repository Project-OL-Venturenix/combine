package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.venturenix.cmc.entity.UserScore;
import com.venturenix.cmc.payload.request.UserScoreRequest;
import jakarta.validation.Valid;

public interface UserScoreOperation {

  @PostMapping("/userscores/addScore")
  boolean addScore(@RequestParam String eventid, //
      @RequestParam String userid, //
      @RequestParam String questionid, //
      @RequestParam String testcasePassTotal);

  @PostMapping("/userscores/add")
  ResponseEntity<?> addUserScore(
      @Valid @RequestBody UserScoreRequest userscoreRequest);

  @GetMapping("/userscores")
  ResponseEntity<List<UserScore>> getAllUserScores();

  @GetMapping("/userscores/{id}")
  ResponseEntity<UserScore> getUserScoreById(@PathVariable long id);

  @PutMapping("/userscores/{id}")
  ResponseEntity<UserScore> updateUserScore(@PathVariable long id,
      @RequestBody UserScore userscore);

  @DeleteMapping("/userscores/{id}")
  ResponseEntity<?> deleteUserScore(@PathVariable long id);
}
