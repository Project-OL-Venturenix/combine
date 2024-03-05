package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.venturenix.cmc.entity.GroupUserQuestionHandle;
import com.venturenix.cmc.payload.request.GroupUserQuestionHandleRequest;
import com.venturenix.cmc.payload.response.GroupuserQuestionDTO;
import jakarta.validation.Valid;

public interface GroupUserQuestionHandleOperation {


        @PostMapping("/groupuserquestionhandles/add")
        ResponseEntity<?> addGroupUserQuestionHandle(
                        @Valid @RequestBody GroupUserQuestionHandleRequest groupuserquestionhandleRequest);

        @GetMapping("/groupuserquestionhandles")
        ResponseEntity<List<GroupUserQuestionHandle>> getAllGroupUserQuestionHandles();

        @GetMapping("/groupuserquestionhandles/{id}")
        ResponseEntity<GroupUserQuestionHandle> getGroupUserQuestionHandleById(
                        @PathVariable long id);

        @PutMapping("/groupuserquestionhandles/{id}")
        ResponseEntity<GroupUserQuestionHandle> updateGroupUserQuestionHandle(
                        @PathVariable long id,
                        @RequestBody GroupUserQuestionHandle groupuserquestionhandle);

        @DeleteMapping("/groupuserquestionhandles/{id}")
        ResponseEntity<?> deleteGroupUserQuestionHandle(@PathVariable long id);
}
