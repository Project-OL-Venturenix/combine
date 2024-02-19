package com.venturenix.cmc.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "groupquestionsubmit")
public class GroupQuestionSubmit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long event_id;
  private Long group_id;
  private Long user_id;
  private Long question_id;
  private LocalDateTime submit_time;
  private Double run_time_by_sec;
  private String status;
  private LocalDateTime createddate;
  private Long createdby;
  private LocalDateTime updateddate;
  private Long updatedby;


  public GroupQuestionSubmit(Long event_id, Long group_id,Long user_id, Long question_id,LocalDateTime submit_time, Double run_time_by_sec,String status, LocalDateTime createddate, Long createdby, LocalDateTime updateddate, Long updatedby) {
    this.event_id = event_id;
    this.group_id = group_id;
    this.user_id = user_id;
    this.question_id = question_id;
    this.submit_time = submit_time;
    this.run_time_by_sec = run_time_by_sec;
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

  public Long getGroupid() {
    return group_id;
  }

  public void setGroupid(Long group_id) {
    this.group_id = group_id;
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

  public LocalDateTime getSubmittime() {
    return submit_time;
  }  

  public void setSubmittime(LocalDateTime submit_time) {
    this.submit_time = submit_time;
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