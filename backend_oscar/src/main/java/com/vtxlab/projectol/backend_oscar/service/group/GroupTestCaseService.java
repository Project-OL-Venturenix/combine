package com.vtxlab.projectol.backend_oscar.service.group;

import java.util.List;
import com.vtxlab.projectol.backend_oscar.entity.group.GroupTestCase;
import com.vtxlab.projectol.backend_oscar.payload.request.group.GroupTestCaseRequest;

public interface GroupTestCaseService {

  void addGroupTestCase(GroupTestCaseRequest grouptestcaseRequest);

  List<GroupTestCase> getAllGroupTestCases();

  GroupTestCase getGroupTestCaseById(long id);

  GroupTestCase updateGroupTestCase(long id, GroupTestCase grouptestcase);

  void deleteGroupTestCase(long id);
}
