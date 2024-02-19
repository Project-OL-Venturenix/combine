package com.venturenix.cmc.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "groupuserquestionhandle")
public class GroupUserQuestionHandle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long event_id;
  private Long group_id;
  private String user_list;
  private Long question_id;
  private String status;
  private LocalDateTime createddate;
  private Long createdby;
  private LocalDateTime updateddate;
  private Long updatedby;

  public GroupUserQuestionHandle(Long event_id, Long group_id, String user_list, Long question_id, String status, LocalDateTime createddate, Long createdby, LocalDateTime updateddate, Long updatedby) {
    this.event_id = event_id;
    this.group_id = group_id;
    this.user_list = user_list;
    this.question_id = question_id;
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

  public Long getGroupId() {
    return group_id;
  }

  public void setGroupid(Long group_id) {
    this.group_id = group_id;
  }

  public String getUserlist() {
    return user_list;
  }

  public void setUserList(String user_list) {
    this.user_list = user_list;
  }  

  public Long getQuestionid() {
    return question_id;
  }

  public void setQuestionid(Long question_id) {
    this.question_id = question_id;
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

  public LocalDateTime getCreatedDate() {
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