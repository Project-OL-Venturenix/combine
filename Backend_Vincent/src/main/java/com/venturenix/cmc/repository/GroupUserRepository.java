package com.venturenix.cmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.GroupUser;
import java.util.List;

@Repository
public interface GroupUserRepository extends JpaRepository<GroupUser, Long> {

    @Query("SELECT gu.userId FROM GroupUser gu WHERE gu.groupId = ?1")
    List<Long> findUserIdsByGroupId(Long groupId);

    @Query("SELECT DISTINCT gu.groupId FROM GroupUser gu")
    List<Long> findDistinctGroupIds();
}
