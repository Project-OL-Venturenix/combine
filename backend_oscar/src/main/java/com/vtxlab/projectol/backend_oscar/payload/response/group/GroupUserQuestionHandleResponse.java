package com.vtxlab.projectol.backend_oscar.payload.response.group;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class GroupUserQuestionHandleResponse {
  private String token;
  private String type = "Bearer";
  private Long id; 

  private Long eventId;


  private Long groupId;

  private String userlist;  

  private Long questionId;  

  private String status;
  
  private LocalDateTime createdDate;

  
  private Integer createdBy;

  
  private LocalDateTime updatedDate;

  
  private Integer updatedBy;
  
  
  public GroupUserQuestionHandleResponse(String accessToken, Long id, Long eventId, Long groupId, String userlist, Long questionId, String status, LocalDateTime createdDate, Integer createdBy, LocalDateTime updatedDate, Integer updatedBy) {
    this.token = accessToken;
    this.id = id;
    this.eventId = eventId;
    this.groupId = groupId;
    this.userlist = userlist;
    this.questionId = questionId;
    this.status = status;
    this.createdDate = createdDate;
    this.createdBy = createdBy;
    this.updatedDate = updatedDate;
    this.updatedBy = updatedBy;
  
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

    public Long getEventId() {
    return eventId;
  }

  public void setEventid(Long eventId) {
    this.eventId = eventId;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupid(Long groupId) {
    this.groupId = groupId;
  }  

  public String getUserlist() {
    return userlist;
  }

  public void setUserlist(String userlist) {
    this.userlist = userlist;
  }  

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionid(Long questionId) {
    this.questionId = questionId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

   public Integer getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Integer updatedBy) {
    this.updatedBy = updatedBy;
  }

  public LocalDateTime getupdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(LocalDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }
}
