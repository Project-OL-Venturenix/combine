package com.vtxlab.projectol.backend_oscar.service.group;

import java.util.List;
import com.vtxlab.projectol.backend_oscar.entity.group.GroupScore;
import com.vtxlab.projectol.backend_oscar.payload.request.group.GroupScoreRequest;

public interface GroupScoreService {
  void addGroupScore(GroupScoreRequest groupscoreRequest);

  List<GroupScore> getAllGroupScores();

  GroupScore getGroupScoreById(long id);

  GroupScore updateGroupScore(long id, GroupScore groupscore);

  void deleteGroupScore(long id);

}
