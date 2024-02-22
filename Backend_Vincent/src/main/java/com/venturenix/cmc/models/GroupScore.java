package com.venturenix.cmc.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "groupscores")
public class GroupScore {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long eventid;
  private Long groupid;
  private Long questionid;
  private Integer testcase_total;
  private Integer testcase_pass_total;
  private Double testcase_score_total;
  private String status;
  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby;


  public GroupScore() {
    
  }

  public GroupScore(Long eventid, Long groupid, Long questionid, Integer testcase_pass_total, Double testcase_score_total, Integer testcase_total, String status, LocalDateTime createddate, Integer createdby, LocalDateTime updateddate, Integer updatedby) {
    this.eventid = eventid;
    this.groupid = groupid;
    this.questionid = questionid;
    this.testcase_pass_total = testcase_pass_total;
    this.testcase_score_total = testcase_score_total;
    this.testcase_total = testcase_total;
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
    return eventid;
  }

  public void setEventid(Long eventid) {
    this.eventid = eventid;
  }  

  public Long getGroupid() {
    return groupid;
  }

  public void setGroupid(Long groupid) {
    this.groupid = groupid;
  }

  public Long getQuestionid() {
    return questionid;
  }

  public void setQuestionid(Long questionid) {
    this.questionid = questionid;
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