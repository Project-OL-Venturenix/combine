package com.venturenix.cmc.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.entity.GroupUser;
import com.venturenix.cmc.entity.GroupUserDTO;
import com.venturenix.cmc.payload.request.GroupUserRequest;
import jakarta.validation.Valid;

public interface GroupUserOperation {
  @PostMapping("/groupuser/add")

  ResponseEntity<?> addGroupUser(
      @Valid @RequestBody GroupUserRequest groupuserRequest);

  @GetMapping("/groupusers")
  ResponseEntity<List<GroupUserDTO>> getAllGroupUsers();

  @GetMapping("/groupuser/{id}")
  ResponseEntity<GroupUser> getGroupUserById(@PathVariable long id);

  @PutMapping("/groupuser/{id}")
  ResponseEntity<GroupUser> updateGroupUser(@PathVariable long id,
      @RequestBody GroupUser groupuser);

  @DeleteMapping("/groupuser/{id}")
  ResponseEntity<?> deleteGroupUser(@PathVariable long id);
}
