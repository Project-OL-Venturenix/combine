package com.vtxlab.projectol.backend_oscar.repository.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.projectol.backend_oscar.entity.user.ERole;
import com.vtxlab.projectol.backend_oscar.entity.user.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
