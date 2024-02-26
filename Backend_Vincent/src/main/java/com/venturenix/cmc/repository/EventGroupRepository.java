package com.venturenix.cmc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.EventGroup;

@Repository
public interface EventGroupRepository extends JpaRepository<EventGroup, Long> {
      
}