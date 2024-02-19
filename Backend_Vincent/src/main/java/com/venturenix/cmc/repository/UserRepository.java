package com.venturenix.cmc.repository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venturenix.cmc.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional <User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
