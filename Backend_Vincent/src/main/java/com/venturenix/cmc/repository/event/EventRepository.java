package com.venturenix.cmc.repository.event;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.event.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {



}
