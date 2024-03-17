// package com.venturenix.cmc.controllers.group.impl;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.venturenix.cmc.controllers.group.GroupScoreOperation;
// import com.venturenix.cmc.entity.group.GroupScore;
// import com.venturenix.cmc.payload.request.GroupScoreRequest;
// import com.venturenix.cmc.payload.response.MessageResponse;
// import com.venturenix.cmc.repository.group.GroupScoreRepository;
// import com.venturenix.cmc.repository.user.RoleRepository;
// import com.venturenix.cmc.repository.user.UserRepository;
// import com.venturenix.cmc.security.jwt.JwtUtils;

// @CrossOrigin(origins = "*", maxAge = 3600)
// @RestController
// @RequestMapping("/api")
// public class GroupScoreController implements GroupScoreOperation {
//   @Autowired
//   AuthenticationManager authenticationManager;


//   @Autowired
//   UserRepository userRepository;

//   @Autowired
//   RoleRepository roleRepository;

//   @Autowired
//   PasswordEncoder encoder;

//   @Autowired
//   JwtUtils jwtUtils;

//   @Autowired
//   GroupScoreRepository groupscoreRepository;


//   public ResponseEntity<?> addGroupScore(GroupScoreRequest groupscoreRequest) {
//     GroupScore builder = GroupScore.builder()//
//         .eventId(groupscoreRequest.getEventId())//
//         .groupId(groupscoreRequest.getGroupId())//
//         .questionId(groupscoreRequest.getQuestionId())//
//         .testcaseTotal(groupscoreRequest.getTestcaseTotal())//
//         .testcasepassTotal(groupscoreRequest.getTestcasepassTotal())//
//         .testcasescoreTotal(groupscoreRequest.getTestcasescoreTotal())//
//         .status(groupscoreRequest.getStatus())//
//         .createdBy(groupscoreRequest.getCreatedBy())//
//         .createdDate(LocalDateTime.now())//
//         .updatedBy(groupscoreRequest.getUpdatedBy())//
//         .updatedDate(LocalDateTime.now())//
//         .build();
//     groupscoreRepository.save(builder);
//     return ResponseEntity
//         .ok(new MessageResponse("Add GroupScore successfully!"));

//   }

//   public ResponseEntity<List<GroupScore>> getAllGroupScores() {
//     try {
//       List<GroupScore> groupscores = groupscoreRepository.findAll();
//       if (groupscores.isEmpty()) {
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//       }
//       return new ResponseEntity<>(groupscores, HttpStatus.OK);
//     } catch (Exception e) {
//       return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

//     }

//   }

//   public ResponseEntity<GroupScore> getGroupScoreById(long id) {
//     Optional<GroupScore> groupscoreData = groupscoreRepository.findById(id);
//     if (groupscoreData.isPresent()) {
//       return new ResponseEntity<>(groupscoreData.get(), HttpStatus.OK);
//     } else {
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
//   }

//   public ResponseEntity<GroupScore> updateGroupScore(long id,
//       GroupScore groupscore) {
//     Optional<GroupScore> groupscoreData = groupscoreRepository.findById(id);

//     if (groupscoreData.isPresent()) {
//       GroupScore builder = GroupScore.builder()//
//           .eventId(groupscore.getEventId())//
//           .groupId(groupscore.getGroupId())//
//           .questionId(groupscore.getQuestionId())//
//           .testcaseTotal(groupscore.getTestcaseTotal())//
//           .testcasepassTotal(groupscore.getTestcasepassTotal())//
//           .testcasescoreTotal(groupscore.getTestcasescoreTotal())//
//           .status(groupscore.getStatus())//
//           .createdBy(groupscore.getCreatedBy())//
//           .createdDate(LocalDateTime.now())//
//           .updatedBy(groupscore.getUpdatedBy())//
//           .updatedDate(LocalDateTime.now())//
//           .build();

//       return new ResponseEntity<>(groupscoreRepository.save(builder),
//           HttpStatus.OK);
//     } else {
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
//   }

//   public ResponseEntity<?> deleteGroupScore(long id) {
//     try {
//       groupscoreRepository.deleteById(id);
//       return ResponseEntity.ok(
//           new MessageResponse("Delete GroupScore " + id + " successfully!"));
//     } catch (Exception e) {
//       return ResponseEntity
//           .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
//     }
//   }
// }
