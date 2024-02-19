package com.venturenix.cmc.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "userquestionsubmit")
public class UserQuestionSubmit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer event_id;
  private Integer user_id;
  private Integer question_id;
  private LocalDateTime submit_time;
  private Double run_time_by_sec;
  private String status;
  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby;

  public UserQuestionSubmit(Integer event_id, Integer user_id, Integer question_id, LocalDateTime submit_time, Double run_time_by_sec, String status, LocalDateTime createddate, Integer createdby, LocalDateTime updateddate, Integer updatedby) {
    this.event_id = event_id;
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