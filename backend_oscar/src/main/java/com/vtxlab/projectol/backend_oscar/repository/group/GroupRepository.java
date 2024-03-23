package com.vtxlab.projectol.backend_oscar.repository.group;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.projectol.backend_oscar.entity.group.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

  List<Group> findByGroupsId(Long groupsId);

  Optional<Group> findByEventsId(Long eventId);

  Optional<Group> findByEventsIdAndUsersId(Long eventId, Long userId);
}
