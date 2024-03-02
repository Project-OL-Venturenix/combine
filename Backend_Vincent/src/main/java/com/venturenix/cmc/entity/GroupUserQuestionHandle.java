package com.venturenix.cmc.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groupuserquestionhandle")
public class GroupUserQuestionHandle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long eventid;
  private Long groupid;
  private Long userid;
  private Long questionid;
  private String status;
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;

  public GroupUserQuestionHandle(Long eventid, Long groupid, Long userid,
      Long questionid, String status, LocalDateTime createdDate,
      Integer createdBy, LocalDateTime updatedDate, Integer updatedBy) {
    this.eventid = eventid;
    this.groupid = groupid;
    this.userid = userid;
    this.questionid = questionid;
    this.status = status;
    this.createdDate = createdDate;
    this.createdBy = createdBy;
    this.updatedDate = updatedDate;
    this.updatedBy = updatedBy;

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

  public Long getUserid() {
    return userid;
  }

  public void setUserlist(Long userid) {
    this.userid = userid;
  }

  public Long getQuestionid() {
    return questionid;
  }

  public void setQuestionid(Long questionid) {
    this.questionid = questionid;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getCreatedby() {
    return createdBy;
  }

  public void setCreatedby(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreateddate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public Integer getUpdatedby() {
    return updatedBy;
  }

  public void setUpdatedby(Integer updatedBy) {
    this.updatedBy = updatedBy;
  }

  public LocalDateTime getUpdateddate() {
    return updatedDate;
  }

  public void setUpdateddate(LocalDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }


}
