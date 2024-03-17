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
// import com.venturenix.cmc.controllers.group.GroupTestCaseOperation;
// import com.venturenix.cmc.entity.group.GroupTestCase;
// import com.venturenix.cmc.payload.request.GroupTestCaseRequest;
// import com.venturenix.cmc.payload.response.MessageResponse;
// import com.venturenix.cmc.repository.group.GroupTestCaseRepository;
// import com.venturenix.cmc.repository.user.RoleRepository;
// import com.venturenix.cmc.repository.user.UserRepository;
// import com.venturenix.cmc.security.jwt.JwtUtils;

// @CrossOrigin(origins = "*", maxAge = 3600)
// @RestController
// @RequestMapping("/api")
// public class GroupTestCaseController implements GroupTestCaseOperation {
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
//   GroupTestCaseRepository grouptestcaseRepository;


//   public ResponseEntity<?> addGroupTestCase(
//       GroupTestCaseRequest grouptestcaseRequest) {
//     GroupTestCase builder = GroupTestCase.builder()//
//         .eventId(grouptestcaseRequest.getEventId())//
//         .groupId(grouptestcaseRequest.getGroupId())//
//         .questionId(grouptestcaseRequest.getQuestionId())//
//         .testcaseid(grouptestcaseRequest.getTestcaseid())//
//         .userId(grouptestcaseRequest.getUserId())//
//         .runstartTime(grouptestcaseRequest.getRunstartTime())//
//         .runstartTimeutc(grouptestcaseRequest.getRunstartTimeutc())//
//         .runendTimeutc(grouptestcaseRequest.getRunendTimeutc())//
//         .runendTime(grouptestcaseRequest.getRunendTime())//
//         .runtimeutc(grouptestcaseRequest.getRuntimeutc())//
//         .fileName(grouptestcaseRequest.getFileName())//
//         .testcasefilepath(grouptestcaseRequest.getTestcasefilepath())//
//         .status(grouptestcaseRequest.getStatus())//
//         .createdBy(grouptestcaseRequest.getCreatedBy())//
//         .createdDate(LocalDateTime.now())//
//         .updatedBy(grouptestcaseRequest.getUpdatedBy())//
//         .updatedDate(LocalDateTime.now())//
//         .build();
//     grouptestcaseRepository.save(builder);
//     return ResponseEntity
//         .ok(new MessageResponse("Add GroupTestCase successfully!"));

//   }

//   public ResponseEntity<List<GroupTestCase>> getAllGroupTestCases() {
//     try {
//       List<GroupTestCase> grouptestcases = grouptestcaseRepository.findAll();
//       if (grouptestcases.isEmpty()) {
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//       }
//       return new ResponseEntity<>(grouptestcases, HttpStatus.OK);
//     } catch (Exception e) {
//       return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

//     }

//   }

//   public ResponseEntity<GroupTestCase> getGroupTestCaseById(long id) {
//     Optional<GroupTestCase> grouptestcaseData =
//         grouptestcaseRepository.findById(id);
//     if (grouptestcaseData.isPresent()) {
//       return new ResponseEntity<>(grouptestcaseData.get(), HttpStatus.OK);
//     } else {
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
//   }

//   public ResponseEntity<GroupTestCase> updateGroupTestCase(long id,
//       GroupTestCase grouptestcase) {
//     Optional<GroupTestCase> grouptestcaseData =
//         grouptestcaseRepository.findById(id);

//     if (grouptestcaseData.isPresent()) {
//       GroupTestCase builder = GroupTestCase.builder()//
//           .eventId(grouptestcase.getEventId())//
//           .groupId(grouptestcase.getGroupId())//
//           .questionId(grouptestcase.getQuestionId())//
//           .testcaseid(grouptestcase.getTestcaseid())//
//           .userId(grouptestcase.getUserId())//
//           .runstartTime(grouptestcase.getRunstartTime())//
//           .runstartTimeutc(grouptestcase.getRunstartTimeutc())//
//           .runendTimeutc(grouptestcase.getRunendTimeutc())//
//           .runendTime(grouptestcase.getRunendTime())//
//           .runtimeutc(grouptestcase.getRuntimeutc())//
//           .fileName(grouptestcase.getFileName())//
//           .testcasefilepath(grouptestcase.getTestcasefilepath())//
//           .status(grouptestcase.getStatus())//
//           .createdBy(grouptestcase.getCreatedBy())//
//           .createdDate(LocalDateTime.now())//
//           .updatedBy(grouptestcase.getUpdatedBy())//
//           .updatedDate(LocalDateTime.now())//
//           .build();
//       return new ResponseEntity<>(grouptestcaseRepository.save(builder),
//           HttpStatus.OK);
//     } else {
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
//   }

//   public ResponseEntity<?> deleteGroupTestCase(long id) {
//     try {
//       grouptestcaseRepository.deleteById(id);
//       return ResponseEntity.ok(
//           new MessageResponse("Delete GroupTestCase " + id + " successfully!"));
//     } catch (Exception e) {
//       return ResponseEntity
//           .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
//     }
//   }
// }
