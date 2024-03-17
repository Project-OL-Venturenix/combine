package com.vtxlab.projectol.backend_oscar.controllers.user.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.projectol.backend_oscar.controllers.user.UserScoreOperation;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBonusRuntime;
import com.vtxlab.projectol.backend_oscar.entity.user.User;
import com.vtxlab.projectol.backend_oscar.entity.user.UserScore;
import com.vtxlab.projectol.backend_oscar.payload.request.question.SubmitTimeRunTimeDTO;
import com.vtxlab.projectol.backend_oscar.payload.request.user.UserScoreRequest;
import com.vtxlab.projectol.backend_oscar.payload.response.user.MessageResponse;
import com.vtxlab.projectol.backend_oscar.payload.response.user.UserScoreDTO;
import com.vtxlab.projectol.backend_oscar.repository.event.EventRepository;
import com.vtxlab.projectol.backend_oscar.repository.questionBank.QuestionBankRepository;
import com.vtxlab.projectol.backend_oscar.repository.questionBank.QuestionBonusRuntimeRepo;
import com.vtxlab.projectol.backend_oscar.repository.user.RoleRepository;
import com.vtxlab.projectol.backend_oscar.repository.user.UserQuestionSubmissionRepository;
import com.vtxlab.projectol.backend_oscar.repository.user.UserRepository;
import com.vtxlab.projectol.backend_oscar.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserScoreController implements UserScoreOperation {
  @Autowired
  AuthenticationManager authenticationManager;


  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  UserQuestionSubmissionRepository userscoreRepository;

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private QuestionBankRepository questionRepository;

  @Autowired
  private QuestionBonusRuntimeRepo questionBonusRuntimeRepo;

  public ResponseEntity<?> addUserScore(UserScoreRequest userscoreRequest) {
    Optional<Event> event =
        eventRepository.findById(userscoreRequest.getEventId());
    Optional<User> user = userRepository.findById(userscoreRequest.getUserId());
    Optional<QuestionBank> question =
        questionRepository.findById(userscoreRequest.getQuestionId());
    UserScore userscore = UserScore.builder()//
        .event(event.get())//
        .user(user.get())//
        .question(question.get())//
        .resultOfPassingTestecase(
            userscoreRequest.getResultOfPassingTestecase() == 10 ? 3 : 0)//
        .status(userscoreRequest.getResultOfPassingTestecase() == 10
            ? "Pass All Test Cases"
            : "Fail")//
        .createdDate(LocalDateTime.now())//
        .updatedDate(LocalDateTime.now())//
        .build();

    userscoreRepository.save(userscore);
    return ResponseEntity
        .ok(new MessageResponse("Add UserScore successfully!"));

  }

  public ResponseEntity<List<UserScore>> getAllUserScores() {
    try {
      List<UserScore> userscores = new ArrayList<UserScore>();
      userscoreRepository.findAll().forEach(userscores::add);
      if (userscores.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(userscores, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<UserScore> getUserScoreById(long id) {
    Optional<UserScore> userscoreData = userscoreRepository.findById(id);
    if (userscoreData.isPresent()) {
      return new ResponseEntity<>(userscoreData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // public ResponseEntity<UserScore> updateUserScore(long id,
  // UserScore userscore) {
  // Optional<Event> event =
  // eventRepository.findById(userscore.getEventId());
  // Optional<User> user = userRepository.findById(userscoreRequest.getUserId());
  // Optional<QuestionBank> question =
  // questionRepository.findById(userscoreRequest.getQuestionId());

  // Optional<UserScore> userscoreData = userscoreRepository.findById(id);

  // if (userscoreData.isPresent()) {
  // UserScore userscore = UserScore.builder()//
  // .event(event.get())//
  // .user(user.get())//
  // .question(question.get())//
  // .resultOfPassingTestecase(
  // userscoreRequest.getResultOfPassingTestecase() == 10 ? 3 : 0)//
  // .status(userscoreRequest.getResultOfPassingTestecase() == 10
  // ? "Pass All Test Cases"
  // : "Fail")//
  // .createdDate(LocalDateTime.now())//
  // .updatedDate(LocalDateTime.now())//
  // .build();

  // return new ResponseEntity<>(userscoreRepository.save(userscore),
  // HttpStatus.OK);
  // } else {
  // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  // }
  // }

  public ResponseEntity<?> deleteUserScore(long id) {
    try {
      userscoreRepository.deleteById(id);
      return ResponseEntity
          .ok(new MessageResponse("Delete UserScore " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }

  @Override
  public boolean addScore(String eventid, String userid, String questionid,
      String testcasePassTotal, SubmitTimeRunTimeDTO submitTimeRunTimeDTO) {
    Long eventID = Long.valueOf(eventid);
    Long userID = Long.valueOf(userid);
    Long questionID = Long.valueOf(questionid);

    Optional<Event> event = eventRepository.findById(eventID);
    Optional<User> user = userRepository.findById(userID);
    Optional<QuestionBank> question = questionRepository.findById(questionID);
    Optional<QuestionBonusRuntime> questionBonusRuntime =
        questionBonusRuntimeRepo.findById(questionID);
    Integer testcasePass = Integer.valueOf(testcasePassTotal);
    if (eventRepository.findById(eventID).isPresent()
        && userRepository.findById(userID).isPresent()
        && questionRepository.findById(questionID).isPresent()) {
      userscoreRepository.saveAndFlush(UserScore.builder()//
          .event(event.get())//
          .user(user.get())//
          .question(question.get())//
          .resultOfPassingTestecase(testcasePass)//
          .status(testcasePass == 10 ? "Pass All Test Cases" : "Fail")//
          .submitTime(submitTimeRunTimeDTO.getSubmitTime())//
          .runtimebyMsec(submitTimeRunTimeDTO.getRunTimeByMsec())//

          .BonusUnder30Mins(event.get().getTargetStartTime().getMinute()
              - submitTimeRunTimeDTO.getSubmitTime().getMinute() < 30 ? "1"
                  : "0")//
          .BonusWithinQuestionRuntime(questionBonusRuntime.get()
              .getBonusRuntime() > submitTimeRunTimeDTO.getRunTimeByMsec() ? "1"
                  : "0")//

          .createdDate(LocalDateTime.now())//
          .updatedDate(LocalDateTime.now())//
          .build());
      return true;
    } else {
      return false;
    }
  }

  // @Override
  // public ResponseEntity<UserScoreDTO> getUserTestCaseByEventId(String eventid) {
  // Long eventID = Long.valueOf(eventid);
  // List<UserScore> target = userscoreRepository.findByEventid(eventID);
  // UserScoreDTO result = target.stream()
  // .filter(e -> e.getEventid().equals(eventID))
  // .collect(Collectors.groupingBy(UserScore::getUserid)) // Grouping by userid
  // .entrySet().stream()
  // .map(entry -> {
  // Long userId = entry.getKey();
  // List<UserScore> userScores = entry.getValue();
  // List<UserScoreDTO.UserResult> userResults = new ArrayList<>();

  // // Calculate cumulative scores for each question
  // Map<Long, Integer> scores = new HashMap<>();
  // Map<Long, Integer> questionCount = new HashMap<>();
  // for (UserScore userScore : userScores) {
  // Long questionId = userScore.getQuestionid();
  // scores.put(questionId, scores.getOrDefault(questionId, 0) + userScore.getTestCasePasstotal());
  // questionCount.put(questionId, questionCount.getOrDefault(questionId, 0) + 1);
  // }

  // // Create UserResult object with cumulative scores
  // Optional<User> userOptional = userRepository.findById(userId);
  // userOptional.ifPresent(user -> {
  // Map<String, Integer> scoreMap = new HashMap<>();
  // for (Map.Entry<Long, Integer> data : scores.entrySet()) {
  // Long questionId = data.getKey();
  // int score = data.getValue();
  // int count = questionCount.get(questionId);
  // scoreMap.put("Q" + questionId, score / count);
  // }
  // userResults.add(UserScoreDTO.UserResult.builder()
  // .name(user.getUsername())
  // .score(scoreMap)
  // .build());
  // });

  // // Create UserScoreDTO with eventId and UserResults
  // return UserScoreDTO.builder()
  // .eventId(eventID.intValue())
  // .result(userResults)
  // .build();
  // })
  // .collect(Collectors.toList());

  // return ResponseEntity.ok(result);
  // }
  @Override
  public ResponseEntity<UserScoreDTO> getUserTestCaseByEventId(String eventid) {
    Long eventId = Long.valueOf(eventid);
    List<UserScore> target = userscoreRepository.findByEventId(eventId);

    Map<Long, UserScoreDTO.UserResult> userResultMap = new HashMap<>();

    for (UserScore userScore : target) {
      Optional<User> userOptional =
          userRepository.findById(userScore.getUser().getId());
      if (!userResultMap.containsKey(userScore.getUser().getId())) {
        UserScoreDTO.UserResult userResult = new UserScoreDTO.UserResult();
        userResult.setName(userOptional.get().getUserName()); // Assuming user id as name
        // passingTestCaseNumber
        userResult.setPassingTestCaseNumber(new HashMap<>());
        userResultMap.put(userScore.getUser().getId(), userResult);
        // score
        userResult.setScore(new HashMap<>());
        userResultMap.put(userScore.getUser().getId(), userResult);
        // submitTime
        userResult.setSubmitTime(new HashMap<>());
        userResultMap.put(userScore.getUser().getId(), userResult);
        // runtime
        userResult.setRuntime(new HashMap<>());
        userResultMap.put(userScore.getUser().getId(), userResult);

      }

      String questionKey = "Q" + userScore.getQuestion().getQuestionId();
      int score = userScore.getResultOfPassingTestecase() == 10 ? 3 : 0;
      int bonus30Mins = Integer.valueOf(userScore.getBonusUnder30Mins());
      int runTimeBonus =
          Integer.valueOf(userScore.getBonusWithinQuestionRuntime());
      int total = score + bonus30Mins + runTimeBonus;
      userResultMap.get(userScore.getUser().getId()).getPassingTestCaseNumber()
          .put(questionKey, userScore.getResultOfPassingTestecase());
      UserScoreDTO.UserResult userResult =
          userResultMap.get(userScore.getUser().getId());
      userResult.getScore().put(questionKey, total);
      // submit time
      LocalDateTime submitTime = userScore.getSubmitTime();
      userResult.getSubmitTime().put(questionKey, submitTime);
      // rutime
      String runtime = String.valueOf(userScore.getRuntimebyMsec());
      userResult.getRuntime().put(questionKey, runtime);

    }

    List<UserScoreDTO.UserResult> userResults =
        new ArrayList<>(userResultMap.values());

    UserScoreDTO userScoreDTO = new UserScoreDTO();
    userScoreDTO.setEventId(eventId.intValue());
    userScoreDTO.setResult(userResults);

    return ResponseEntity.ok(userScoreDTO);
  }

}
