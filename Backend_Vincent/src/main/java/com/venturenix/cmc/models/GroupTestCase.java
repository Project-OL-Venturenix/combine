package com.venturenix.cmc.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "grouptestcases")
public class GroupTestCase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer event_id;
  private Integer group_id;
  private Integer user_id;
  private Integer question_id;
  private Integer testcase_id;
  private Double run_time_by_sec;
  private String testcase_pass_status;
  private String status;
  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby;

  public GroupTestCase(Integer event_id, Integer group_id, Integer question_id, Integer testcase_id, Integer user_id, Double run_time_by_sec, String testcase_pass_status, String status, LocalDateTime createddate, Integer createdby, LocalDateTime updateddate, Integer updatedby) {
    this.event_id = event_id;
    this.group_id = group_id;
    this.question_id = question_id;
    this.testcase_id = testcase_id;
    this.user_id = user_id;
    this.run_time_by_sec = run_time_by_sec;
    this.testcase_pass_status = testcase_pass_status;
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

  public Integer getGroupid() {
    return group_id;
  }

  public void setGroupid(Integer group_id) {
    this.group_id = group_id;
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

  public Integer getTestcaseid() {
    return testcase_id;
  }

  public void setTestcaseid(Integer testcase_id) {
    this.testcase_id = testcase_id;
  }  

  public String getTestcasepassstatus() {
    return testcase_pass_status;
  }

  public void setTestcasepassstatus(String testcase_pass_status) {
    this.testcase_pass_status = testcase_pass_status;
  }    

  public Double getRuntimebysec() {
    return run_time_by_sec;
  }  

  public void setRuntimebysec(Double run_time_by_sec) {
    this.run_time_by_sec = run_time_by_sec;
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