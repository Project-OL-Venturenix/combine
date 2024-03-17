package com.vtxlab.projectol.backend_oscar.controllers.group;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.projectol.backend_oscar.entity.group.GroupUserQuestionHandle;
import com.vtxlab.projectol.backend_oscar.payload.request.group.GroupUserQuestionHandleRequest;
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
