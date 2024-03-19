package com.vtxlab.projectol.backend_oscar.service.group;

import java.util.List;
import com.vtxlab.projectol.backend_oscar.entity.group.Group;
import com.vtxlab.projectol.backend_oscar.payload.request.group.GroupRequest;

public interface GroupService {
  void addGroup(GroupRequest groupRequest);

  List<Group> getAllGroups();

  Group getGroupById(long id);

  Group updateGroup(long id, Group group);

  void deleteGroup(long id);

}
