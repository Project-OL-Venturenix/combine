package com.venturenix.cmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.EventUser;

@Repository
public interface EventUserRepository extends JpaRepository<EventUser, Long> {



}
