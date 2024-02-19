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
  private Integer id;
  private Integer event_id;
  private Integer user_id;
  private Integer question_id;
  private Integer testcase_total;
  private Integer testcase_pass_total;
  private Double testcase_score_total;
  private String status;
  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby;


  public UserScore(Integer event_id, Integer user_id, Integer question_id, Integer testcase_total, Integer testcase_pass_total, Double testcase_score_total, String status, LocalDateTime createddate, Integer createdby, LocalDateTime updateddate, Integer updatedby) {
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getEventid() {
    return event_id;
  }

  public void setEventid(Integer event_id) {
    this.event_id = event_id;
  }  

  public Integer getUserid() {
    return user_id;
  }

  public void setUserid(Integer user_id) {
    this.user_id = user_id;
  }

  public Integer getQuestionid() {
    return question_id;
  }

  public void setQuestionid(Integer question_id) {
    this.question_id = question_id;
  }  

  public Integer getTestcasetotal() {
    return testcase_total;
  }

  public void setTestcasetotal(Integer testcase_total) {
    this.testcase_total = testcase_total;
  }  

  public Integer getTestcasepasstotal() {
    return testcase_pass_total;
  }

  public void setTestcasepasstotal(Integer testcase_pass_total) {
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

  public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }  

  public LocalDateTime getCreateddate() {
    return createddate;
  }

  public void setCreateddate(LocalDateTime createddate) {
    this.createddate = createddate;
  }  

  public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }   

  public LocalDateTime getUpdateddate() {
    return updateddate;
  }

  public void setUpdateddate(LocalDateTime updateddate) {
    this.updateddate = updateddate;
  }  


}