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
// import com.venturenix.cmc.controllers.group.GroupQuestionSubmitOperation;
// import com.venturenix.cmc.entity.group.GroupQuestionSubmit;
// import com.venturenix.cmc.payload.request.GroupQuestionSubmitRequest;
// import com.venturenix.cmc.payload.response.MessageResponse;
// import com.venturenix.cmc.repository.group.GroupQuestionSubmitRepository;
// import com.venturenix.cmc.repository.user.RoleRepository;
// import com.venturenix.cmc.repository.user.UserRepository;
// import com.venturenix.cmc.security.jwt.JwtUtils;

// @CrossOrigin(origins = "*", maxAge = 3600)
// @RestController
// @RequestMapping("/api")
// public class GroupQuestionSubmitController
//     implements GroupQuestionSubmitOperation {
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
//   GroupQuestionSubmitRepository groupquestionsubmitRepository;


//   public ResponseEntity<?> addGroupQuestionSubmit(
//       GroupQuestionSubmitRequest groupquestionsubmitRequest) {
//     GroupQuestionSubmit builder = GroupQuestionSubmit.builder()//
//         .eventId(groupquestionsubmitRequest.getEventId())//
//         .groupId(groupquestionsubmitRequest.getGroupId())//
//         .questionId(groupquestionsubmitRequest.getQuestionId())//
//         .userId(groupquestionsubmitRequest.getUserId())//
//         .submitTime(groupquestionsubmitRequest.getSubmitTime())//
//         .runtimebyMsec(groupquestionsubmitRequest.getRuntimebyMsec())//
//         .status(groupquestionsubmitRequest.getStatus())//
//         .createdBy(groupquestionsubmitRequest.getCreatedBy())//
//         .createdDate(LocalDateTime.now())//
//         .updatedBy(groupquestionsubmitRequest.getUpdatedBy())//
//         .updatedDate(LocalDateTime.now())//
//         .build();


//     groupquestionsubmitRepository.save(builder);
//     return ResponseEntity
//         .ok(new MessageResponse("Add GroupQuestionSubmit successfully!"));

//   }

//   public ResponseEntity<List<GroupQuestionSubmit>> getAllGroupQuestionSubmits() {
//     try {
//       List<GroupQuestionSubmit> groupquestionsubmits =
//           groupquestionsubmitRepository.findAll();
//       if (groupquestionsubmits.isEmpty()) {
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//       }
//       return new ResponseEntity<>(groupquestionsubmits, HttpStatus.OK);
//     } catch (Exception e) {
//       return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

//     }

//   }

//   public ResponseEntity<GroupQuestionSubmit> getGroupQuestionSubmitById(
//       long id) {
//     Optional<GroupQuestionSubmit> groupquestionsubmitData =
//         groupquestionsubmitRepository.findById(id);
//     if (groupquestionsubmitData.isPresent()) {
//       return new ResponseEntity<>(groupquestionsubmitData.get(), HttpStatus.OK);
//     } else {
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
//   }

//   public ResponseEntity<GroupQuestionSubmit> updateGroupQuestionSubmit(long id,
//       GroupQuestionSubmit groupquestionsubmit) {
//     Optional<GroupQuestionSubmit> groupquestionsubmitData =
//         groupquestionsubmitRepository.findById(id);

//     if (groupquestionsubmitData.isPresent()) {
//       GroupQuestionSubmit builder = GroupQuestionSubmit.builder()//
//           .eventId(groupquestionsubmit.getEventId())//
//           .groupId(groupquestionsubmit.getGroupId())//
//           .questionId(groupquestionsubmit.getQuestionId())//
//           .userId(groupquestionsubmit.getUserId())//
//           .submitTime(groupquestionsubmit.getSubmitTime())//
//           .runtimebyMsec(groupquestionsubmit.getRuntimebyMsec())//
//           .status(groupquestionsubmit.getStatus())//
//           .createdBy(groupquestionsubmit.getCreatedBy())//
//           .createdDate(LocalDateTime.now())//
//           .updatedBy(groupquestionsubmit.getUpdatedBy())//
//           .updatedDate(LocalDateTime.now())//
//           .build();

//       return new ResponseEntity<>(groupquestionsubmitRepository.save(builder),
//           HttpStatus.OK);
//     } else {
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
//   }

//   public ResponseEntity<?> deleteGroupQuestionSubmit(long id) {
//     try {
//       groupquestionsubmitRepository.deleteById(id);
//       return ResponseEntity.ok(new MessageResponse(
//           "Delete GroupQuestionSubmit " + id + " successfully!"));
//     } catch (Exception e) {
//       return ResponseEntity
//           .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
//     }
//   }
// }

