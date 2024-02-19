package com.venturenix.cmc.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "usertestcases")
public class UserTestCase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long event_id;
  private Long user_id;
  private Long question_id;
  private Long testcase_id;
  private String testcase_pass_status;
  private Double run_time_by_sec;
  private String status;
  private LocalDateTime createddate;
  private Long createdby;
  private LocalDateTime updateddate;
  private Long updatedby;

  public UserTestCase(Long event_id, Long user_id, Long question_id, Long testcase_id, Double run_time_by_sec, String testcase_pass_status, String status, LocalDateTime createddate, Long createdby, LocalDateTime updateddate, Long updatedby) {
    this.event_id = event_id;
    this.user_id = user_id;
    this.question_id = question_id;
    this.testcase_id = testcase_id;
    this.run_time_by_sec = run_time_by_sec;
    this.testcase_pass_status = testcase_pass_status;
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

  public Long getTestcaseid() {
    return testcase_id;
  }

  public void setTestcaseid(Long testcase_id) {
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