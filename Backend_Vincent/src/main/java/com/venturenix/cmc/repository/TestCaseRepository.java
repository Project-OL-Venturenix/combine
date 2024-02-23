package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.venturenix.cmc.models.TestCase;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
