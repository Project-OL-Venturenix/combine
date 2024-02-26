package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.entity.Group;
import com.venturenix.cmc.payload.request.GroupRequest;
import jakarta.validation.Valid;

public interface GroupOperation {
  @PostMapping("/group/add")
  ResponseEntity<?> addGroup(@Valid @RequestBody GroupRequest groupRequest);

  @GetMapping("/groups")
  ResponseEntity<List<Group>> getAllGroups();

  @GetMapping("/group/{id}")
  ResponseEntity<Group> getGroupById(@PathVariable("id") long id);

  @PutMapping("/group/{id}")
  ResponseEntity<Group> updateGroup(@PathVariable("id") long id,
      @RequestBody Group group);

  @DeleteMapping("/group/{id}")
  ResponseEntity<?> deleteGroup(@PathVariable("id") long id);

}
