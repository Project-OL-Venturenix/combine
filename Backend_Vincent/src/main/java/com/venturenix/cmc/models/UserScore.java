package com.venturenix.cmc.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "userscores")
public class UserScore {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long event_id;
  private Long user_id;
  private Long question_id;
  private Long testcase_total;
  private Long testcase_pass_total;
  private Double testcase_score_total;
  private String status;
  private LocalDateTime createddate;
  private Long createdby;
  private LocalDateTime updateddate;
  private Long updatedby;


  public UserScore(Long event_id, Long user_id, Long question_id, Long testcase_total, Long testcase_pass_total, Double testcase_score_total, String status, LocalDateTime createddate, Long createdby, LocalDateTime updateddate, Long updatedby) {
    this.event_id = event_id;
    this.user_id = user_id;
    this.question_id = question_id;
    this.testcase_total = testcase_total;
    this.testcase_pass_total = testcase_pass_total;
    this.testcase_score_total = testcase_score_total;
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

  public Long getEventid() {
    return event_id;
  }

  public void setEventid(Long event_id) {
    this.event_id = event_id;
  }  

  public Long getUserid() {
    return user_id;
  }

  public void setUserid(Long user_id) {
    this.user_id = user_id;
  }

  public Long getQuestionid() {
    return question_id;
  }

  public void setQuestionid(Long question_id) {
    this.question_id = question_id;
  }  

  public Long getTestcasetotal() {
    return testcase_total;
  }

  public void setTestcasetotal(Long testcase_total) {
    this.testcase_total = testcase_total;
  }  

  public Long getTestcasepasstotal() {
    return testcase_pass_total;
  }

  public void setTestcasepasstotal(Long testcase_pass_total) {
    this.testcase_pass_total = testcase_pass_total;
  } 

  public Double getTestcasescoretotal() {
    return testcase_score_total;
  }

  public void setTestcasescoretotal(Double testcase_score_total) {
    this.testcase_score_total = testcase_score_total;
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