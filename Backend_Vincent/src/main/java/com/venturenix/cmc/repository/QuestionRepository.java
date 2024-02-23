package com.venturenix.cmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.venturenix.cmc.models.QuestionBank;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionBank, Long> {


}
