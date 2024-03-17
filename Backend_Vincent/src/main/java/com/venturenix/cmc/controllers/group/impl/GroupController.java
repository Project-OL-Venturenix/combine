// package com.venturenix.cmc.controllers.group.impl;

// import java.util.List;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.Optional;

// import jakarta.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.http.HttpStatus;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.venturenix.cmc.controllers.group.GroupOperation;
// import com.venturenix.cmc.entity.group.Group;
// import com.venturenix.cmc.payload.request.GroupRequest;
// import com.venturenix.cmc.payload.response.MessageResponse;
// import com.venturenix.cmc.repository.group.GroupRepository;
// import com.venturenix.cmc.repository.user.RoleRepository;
// import com.venturenix.cmc.repository.user.UserRepository;
// import com.venturenix.cmc.security.jwt.JwtUtils;

// @CrossOrigin(origins = "*", maxAge = 3600)
// @RestController
// @RequestMapping("/api")
// public class GroupController implements GroupOperation {
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
//   GroupRepository groupRepository;

//   public ResponseEntity<?> addGroup(
//       @Valid @RequestBody GroupRequest groupRequest) {
//     Group builder = Group.builder()//
//         .name(groupRequest.getName())//
//         .status(groupRequest.getStatus())//
//         .createdBy(groupRequest.getCreatedBy())//
//         .createdDate(LocalDateTime.now())//
//         .updatedBy(groupRequest.getUpdatedBy())//
//         .updatedDate(LocalDateTime.now())//
//         .build();

//     groupRepository.save(builder);
//     return ResponseEntity.ok(new MessageResponse("Add Group successfully!"));

//   }

//   public ResponseEntity<List<Group>> getAllGroups() {
//     try {
//       List<Group> groups = groupRepository.findAll();
//       if (groups.isEmpty()) {
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//       }
//       return new ResponseEntity<>(groups, HttpStatus.OK);
//     } catch (Exception e) {
//       return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

//     }

//   }

//   public ResponseEntity<Group> getGroupById(long id) {
//     Optional<Group> groupData = groupRepository.findById(id);
//     if (groupData.isPresent()) {
//       return new ResponseEntity<>(groupData.get(), HttpStatus.OK);
//     } else {
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
//   }

//   public ResponseEntity<Group> updateGroup(long id, Group group) {
//     Optional<Group> groupData = groupRepository.findById(id);

//     if (groupData.isPresent()) {
//       Group _group = groupData.get();
//       _group.setName(group.getName());
//       _group.setStatus(group.getStatus());
//       _group.setUpdatedDate(java.time.LocalDateTime.now());
//       _group.setUpdatedBy(group.getUpdatedBy());
//       return new ResponseEntity<>(groupRepository.save(_group), HttpStatus.OK);
//     } else {
//       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
//   }

//   public ResponseEntity<?> deleteGroup(long id) {
//     try {
//       groupRepository.deleteById(id);
//       return ResponseEntity
//           .ok(new MessageResponse("Delete Group " + id + " successfully!"));
//     } catch (Exception e) {
//       return ResponseEntity
//           .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
//     }
//   }
// }
