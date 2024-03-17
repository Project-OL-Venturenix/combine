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
// import com.venturenix.cmc.controllers.group.GroupUserQuestionHandleOperation;
// import com.venturenix.cmc.entity.group.GroupUserQuestionHandle;
// import com.venturenix.cmc.payload.request.GroupUserQuestionHandleRequest;
// import com.venturenix.cmc.payload.response.MessageResponse;
// import com.venturenix.cmc.repository.group.GroupUserQuestionHandleRepository;
// import com.venturenix.cmc.repository.user.RoleRepository;
// import com.venturenix.cmc.repository.user.UserRepository;
// import com.venturenix.cmc.security.jwt.JwtUtils;
// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @CrossOrigin(origins = "*", maxAge = 3600)
// @RestController
// @RequestMapping("/api")
// public class GroupUserQuestionHandleController
//     implements GroupUserQuestionHandleOperation {
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
//   GroupUserQuestionHandleRepository groupuserquestionhandleRepository;

//   public ResponseEntity<?> addGroupUserQuestionHandle(
//       GroupUserQuestionHandleRequest groupuserquestionhandleRequest) {
//     Long eventId = groupuserquestionhandleRequest.getEventId();
//     Long groupId = groupuserquestionhandleRequest.getGroupId();
//     Long questionId = groupuserquestionhandleRequest.getQuestionId();
//     Long userId = groupuserquestionhandleRequest.getUserId();
//     Optional<GroupUserQuestionHandle> checkData =
//         groupuserquestionhandleRepository
//             .findDistinctByEventIdAndGroupIdAndQuestionId(eventId, groupId,
//                 questionId);
//     // keep userList Distinct
//     Optional<List<GroupUserQuestionHandle>> checkUserList =
//         groupuserquestionhandleRepository.findByUserId(userId);
//     if (checkUserList.isPresent()) {
//       groupuserquestionhandleRepository.deleteAll(checkUserList.get());
//     }
//     if (checkData.isPresent()) {
//       checkData.get().setUserId(userId);
//       groupuserquestionhandleRepository.save(checkData.get());
//     } else {
//       GroupUserQuestionHandle builder = GroupUserQuestionHandle.builder()//
//           .eventId(groupuserquestionhandleRequest.getEventId())//
//           .groupId(groupuserquestionhandleRequest.getGroupId())//
//           .userId(groupuserquestionhandleRequest.getUserId())//
//           .questionId(groupuserquestionhandleRequest.getQuestionId())//
//           .status(groupuserquestionhandleRequest.getStatus())//
//           .createdBy(groupuserquestionhandleRequest.getCreatedBy())//
//           .createdDate(LocalDateTime.now())//
//           .updatedBy(groupuserquestionhandleRequest.getUpdatedBy())//
//           .updatedDate(LocalDateTime.now())//
//           .build();


//       groupuserquestionhandleRepository.save(builder);
//     }

//     return ResponseEntity
//         .ok(new MessageResponse("Add GroupUserQuestionHandle successfully!"));

//   }


//   public ResponseEntity<List<GroupUserQuestionHandle>> getAllGroupUserQuestionHandles() {
//     try {
//       List<GroupUserQuestionHandle> groupuserquestionhandles =
//           groupuserquestionhandleRepository.findAll();
//       if (groupuserquestionhandles.isEmpty()) {
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//       }
//       return new ResponseEntity<>(groupuserquestionhandles, HttpStatus.OK);
//     } catch (Exception e) {
//       return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

//     }

//   }

//   public ResponseEntity<GroupUserQuestionHandle> getGroupUserQuestionHandleById(
//       long id) {
//     Optional<GroupUserQuestionHandle> groupuserquestionhandleData =
//         groupuserquestionhandleRepository.findById(id);
//     if (groupuserquestionhandleData.isPresent()) {
//       return new ResponseEntity<>(groupuserquestionhandleData.get(),
//           HttpStatus.OK);
//     } else {
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
//   }

//   public ResponseEntity<GroupUserQuestionHandle> updateGroupUserQuestionHandle(
//       long id, GroupUserQuestionHandle groupuserquestionhandle) {
//     Optional<GroupUserQuestionHandle> groupuserquestionhandleData =
//         groupuserquestionhandleRepository.findById(id);

//     if (groupuserquestionhandleData.isPresent()) {
//       GroupUserQuestionHandle builder = GroupUserQuestionHandle.builder()//
//           .eventId(groupuserquestionhandle.getEventId())//
//           .groupId(groupuserquestionhandle.getGroupId())//
//           .userId(groupuserquestionhandle.getUserId())//
//           .questionId(groupuserquestionhandle.getQuestionId())//
//           .status(groupuserquestionhandle.getStatus())//
//           .createdBy(groupuserquestionhandle.getCreatedBy())//
//           .createdDate(LocalDateTime.now())//
//           .updatedBy(groupuserquestionhandle.getUpdatedBy())//
//           .updatedDate(LocalDateTime.now())//
//           .build();

//       return new ResponseEntity<>(
//           groupuserquestionhandleRepository.save(builder), HttpStatus.OK);
//     } else {
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
//   }

//   public ResponseEntity<?> deleteGroupUserQuestionHandle(long id) {
//     try {
//       groupuserquestionhandleRepository.deleteById(id);
//       return ResponseEntity.ok(new MessageResponse(
//           "Delete GroupUserQuestionHandle " + id + " successfully!"));
//     } catch (Exception e) {
//       return ResponseEntity
//           .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
//     }
//   }


// }
