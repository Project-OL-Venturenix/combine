package com.vtxlab.projectol.backend_oscar.service.group;

import java.util.List;
import com.vtxlab.projectol.backend_oscar.entity.group.GroupQuestionSubmit;
import com.vtxlab.projectol.backend_oscar.payload.request.group.GroupQuestionSubmitRequest;

public interface GroupQuestionSubmitService {
    void addGroupQuestionSubmit(
            GroupQuestionSubmitRequest groupquestionsubmitRequest);

    List<GroupQuestionSubmit> getAllGroupQuestionSubmits();

    GroupQuestionSubmit getGroupQuestionSubmitById(long id);

    GroupQuestionSubmit updateGroupQuestionSubmit(long id,
            GroupQuestionSubmit groupquestionsubmit);

    void deleteGroupQuestionSubmit(long id);

}
