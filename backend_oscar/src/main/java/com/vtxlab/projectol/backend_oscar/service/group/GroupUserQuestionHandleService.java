package com.vtxlab.projectol.backend_oscar.service.group;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.projectol.backend_oscar.entity.group.GroupUserQuestionHandle;
import com.vtxlab.projectol.backend_oscar.payload.request.group.GroupUserQuestionHandleRequest;

public interface GroupUserQuestionHandleService {

        void addGroupUserQuestionHandle(
                        GroupUserQuestionHandleRequest groupuserquestionhandleRequest);

        List<GroupUserQuestionHandle> getAllGroupUserQuestionHandles();

        GroupUserQuestionHandle getGroupUserQuestionHandleById(
                        @PathVariable long id);

        GroupUserQuestionHandle updateGroupUserQuestionHandle(long id,
                        GroupUserQuestionHandle groupuserquestionhandle);

        void deleteGroupUserQuestionHandle(@PathVariable long id);
}
