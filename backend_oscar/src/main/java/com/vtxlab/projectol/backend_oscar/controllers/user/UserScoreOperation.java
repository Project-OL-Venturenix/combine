package com.vtxlab.projectol.backend_oscar.controllers.user;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.projectol.backend_oscar.entity.user.UserScore;
import com.vtxlab.projectol.backend_oscar.payload.request.question.SubmitTimeRunTimeDTO;
import com.vtxlab.projectol.backend_oscar.payload.request.user.UserScoreRequest;
import com.vtxlab.projectol.backend_oscar.payload.response.user.UserScoreDTO;
import jakarta.validation.Valid;

public interface UserScoreOperation {

  @PostMapping("/userscores/addScore")
  boolean addScore(@RequestParam String eventid, //
      @RequestParam String userid, //
      @RequestParam String questionid, //
      @RequestParam String testcasePassTotal,
      @RequestBody SubmitTimeRunTimeDTO submitTimeRunTimeDTO);

  @PostMapping("/userscores")
  ResponseEntity<?> addUserScore(
      @Valid @RequestBody UserScoreRequest userscoreRequest);

  @GetMapping("/userscores")
  ResponseEntity<List<UserScore>> getAllUserScores();

  @GetMapping("/userscores/{id}")
  ResponseEntity<UserScore> getUserScoreById(@PathVariable long id);

//   @PutMapping("/userscores/{id}")
//   ResponseEntity<UserScore> updateUserScore(@PathVariable long id,
//       @RequestBody UserScore userscore);

  @DeleteMapping("/userscores/{id}")
  ResponseEntity<?> deleteUserScore(@PathVariable long id);

  // return ResponseEntity.ok(result);
  // }

  @GetMapping("/usertestcases/eventid/{eventid}")
  ResponseEntity<UserScoreDTO> getUserTestCaseByEventId(@PathVariable String eventid);
}