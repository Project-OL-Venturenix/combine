package com.vtxlab.projectol.backend_oscar.service.user.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBonusRuntime;
import com.vtxlab.projectol.backend_oscar.entity.user.User;
import com.vtxlab.projectol.backend_oscar.entity.user.UserScore;
import com.vtxlab.projectol.backend_oscar.payload.request.question.SubmitTimeRunTimeDTO;
import com.vtxlab.projectol.backend_oscar.payload.request.user.UserScoreRequest;
import com.vtxlab.projectol.backend_oscar.payload.response.user.UserScoreDTO;
import com.vtxlab.projectol.backend_oscar.repository.event.EventRepository;
import com.vtxlab.projectol.backend_oscar.repository.questionBank.QuestionBankRepository;
import com.vtxlab.projectol.backend_oscar.repository.questionBank.QuestionBonusRuntimeRepo;
import com.vtxlab.projectol.backend_oscar.repository.user.RoleRepository;
import com.vtxlab.projectol.backend_oscar.repository.user.UserQuestionSubmissionRepository;
import com.vtxlab.projectol.backend_oscar.repository.user.UserRepository;
import com.vtxlab.projectol.backend_oscar.service.user.UserScoreService;

@Service
public class UserScoreServiceImpl implements UserScoreService {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  private UserQuestionSubmissionRepository userscoreRepository;

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private QuestionBankRepository questionRepository;

  @Autowired
  private QuestionBonusRuntimeRepo questionBonusRuntimeRepo;


  @Override
  public boolean addScore(Long eventid, Long userid, Long questionid,
      Integer testcasePass, SubmitTimeRunTimeDTO submitTimeRunTimeDTO) {
    Optional<UserScore> builder = userscoreRepository
        .findByEventIdAndUserIdAndQuestionId(eventid, userid, questionid);
    if (!builder.isPresent()) {
      Optional<Event> event = eventRepository.findById(eventid);
      Optional<User> user = userRepository.findById(userid);
      Optional<QuestionBank> question = questionRepository.findById(questionid);
      Optional<QuestionBonusRuntime> questionBonusRuntime =
          questionBonusRuntimeRepo.findById(questionid);

      if (event.isPresent() && user.isPresent() && question.isPresent()) {
        userscoreRepository.saveAndFlush(UserScore.builder().event(event.get())
            .user(user.get()).question(question.get())//
            .resultOfPassingTestecase(testcasePass)//
            .status(testcasePass == 10 ? "Pass All Test Cases" : "Fail")//
            .submitTime(submitTimeRunTimeDTO.getSubmitTime())//
            .runtimebyMsec(submitTimeRunTimeDTO.getRunTimeByMsec())//
            .bonusUnder30Mins(event.get().getTargetStartTime().getMinute()
                - submitTimeRunTimeDTO.getSubmitTime().getMinute() < 30
                && testcasePass == 10 ? "1" : "0")//
            .bonusWithinQuestionRuntime(questionBonusRuntime.get()
                .getBonusRuntime() > submitTimeRunTimeDTO.getRunTimeByMsec()
                    ? "1"
                    : "0")//
            .createdDate(LocalDateTime.now()).updatedDate(LocalDateTime.now())
            .build());
        return true;
      } else {
        return false;
      }
    } else {
      builder.get().setResultOfPassingTestecase(testcasePass);
      builder.get().setSubmitTime(submitTimeRunTimeDTO.getSubmitTime());
      builder.get().setRuntimebyMsec(submitTimeRunTimeDTO.getRunTimeByMsec());
      userscoreRepository.save(builder.get());
      return true;
    }
  }

  @Override
  public boolean addUserScore(UserScoreRequest userscoreRequest) {
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
    return true;
  }

  @Override
  public List<UserScore> getAllUserScores() {
    return userscoreRepository.findAll();
  }

  @Override
  public UserScore getUserScoreById(Long id) {
    Optional<UserScore> userscoreData = userscoreRepository.findById(id);
    return userscoreData.get();
  }

  @Override
  public void deleteUserScore(Long id) {
    userscoreRepository.deleteById(id);
  }

  @Override
  public UserScoreDTO getUserTestCaseByEventId(Long eventId) {
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

    return userScoreDTO;
  }

}
