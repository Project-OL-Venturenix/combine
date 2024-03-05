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
import com.venturenix.cmc.payload.request.GroupUserRequest;
import com.venturenix.cmc.payload.response.GroupUserDTO;
import jakarta.validation.Valid;

public interface GroupUserOperation {
  @PostMapping("/groupusers/add")
  ResponseEntity<?> addGroupUser(
      @Valid @RequestBody GroupUserRequest groupuserRequest);

  @GetMapping("/groupusers")
  ResponseEntity<List<GroupUserDTO>> getAllGroupUsers();

  @GetMapping("/groupusers/{id}")
  ResponseEntity<GroupUser> getGroupUserById(@PathVariable long id);

  @PutMapping("/groupusers/{id}")
  ResponseEntity<GroupUser> updateGroupUser(@PathVariable long id,
      @RequestBody GroupUser groupuser);

  @DeleteMapping("/groupusers/{id}")
  ResponseEntity<?> deleteGroupUser(@PathVariable long id);
}
