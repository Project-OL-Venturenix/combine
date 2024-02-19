package com.venturenix.cmc.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "testcasescores")
public class TestCaseScore {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String testcase_score_desc;
  private Double testcase_score;
  private String status;
  private LocalDateTime createddate;
  private Long createdby;
  private LocalDateTime updateddate;
  private Long updatedby;  

  public TestCaseScore(String testcase_score_desc, Double testcase_score, String status, LocalDateTime createddate, Long createdby, LocalDateTime updateddate, Long updatedby) {
    this.testcase_score_desc = testcase_score_desc;
    this.testcase_score = testcase_score;
    this.status = status;
    this.createddate = createddate;
    this.createdby = createdby;
    this.updateddate = updateddate;
    this.updatedby = updatedby;
    
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTestcasescoredesc() {
    return testcase_score_desc;
  }

  public void setTestcasescoredesc(String testcase_score_desc) {
    this.testcase_score_desc = testcase_score_desc;
  }  

  public Double getTestcasescore() {
    return testcase_score;
  }

  public void setTestcasescore(Double testcase_score) {
    this.testcase_score = testcase_score;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Long createdby) {
    this.createdby = createdby;
  }  

  public LocalDateTime getCreateddate() {
    return createddate;
  }

  public void setCreateddate(LocalDateTime createddate) {
    this.createddate = createddate;
  }  

  public Long getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Long updatedby) {
    this.updatedby = updatedby;
  }   

  public LocalDateTime getUpdateddate() {
    return updateddate;
  }

  public void setUpdateddate(LocalDateTime updateddate) {
    this.updateddate = updateddate;
  }   

}