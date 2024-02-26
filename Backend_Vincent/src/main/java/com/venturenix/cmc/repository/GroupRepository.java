package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.Group;
import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findById(Long id);

    Group findByName(String name);

    List<Group> findAll();
    
    

  
}