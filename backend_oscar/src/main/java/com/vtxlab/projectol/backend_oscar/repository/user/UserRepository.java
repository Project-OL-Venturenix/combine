package com.vtxlab.projectol.backend_oscar.repository.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.projectol.backend_oscar.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUserName(String userName);

  Boolean existsByUserName(String userName);

  Boolean existsByEmail(String email);

  Optional<User> findByEventsIdAndUserName(Long eventId, String userName);

}
