package com.vtxlab.projectol.backend_oscar.repository.group;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vtxlab.projectol.backend_oscar.entity.group.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

  public List<Group> findByGroupsId(Long groupsId);
  
}