package com.vtxlab.projectol.backend_oscar.repository.event;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {



}
