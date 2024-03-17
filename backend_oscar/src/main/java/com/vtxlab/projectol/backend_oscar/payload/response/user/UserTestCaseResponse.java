package com.vtxlab.projectol.backend_oscar.payload.response.user;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

public class UserTestCaseResponse {
  private String token;
  private String type = "Bearer";
  private Long id; 
 
  private Long eventId;

  private Long questionId;

  private Long testcaseid;

  private Long userId;

  private OffsetDateTime runstartTimeutc;

  private OffsetDateTime  runendTimeutc;

  private LocalDateTime  runstartTime;    

  private LocalDateTime runendTime;

  private String testcasefilepath;

  private String fileName;    

  private String testcasepassstatus;

  private String status;
  
  private LocalDateTime createdDate;

  
  private Integer createdBy;

  
  private LocalDateTime updatedDate;

  
  private Integer updatedBy;
  
  
  public UserTestCaseResponse(String accessToken, Long id, Long eventId, Long questionId, Long testcaseid, Long userId, OffsetDateTime runstartTimeutc, OffsetDateTime runendTimeutc, LocalDateTime runstartTime, LocalDateTime runendTime, String testcasefilepath, String fileName, String testcasepassstatus, String status, LocalDateTime createdDate, Integer createdBy, LocalDateTime updatedDate, Integer updatedBy) {
    this.token = accessToken;
    this.id = id;
    this.eventId = eventId;
    this.questionId = questionId;
    this.testcaseid = testcaseid;
    this.userId = userId;
    this.runstartTimeutc = runstartTimeutc;
    this.runendTimeutc = runendTimeutc;
    this.runstartTime = runstartTime;
    this.runendTime = runendTime;
    this.testcasefilepath = testcasefilepath;    
    this.fileName = fileName;
    this.testcasepassstatus = testcasepassstatus;  
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


  public Long getUserId() {
    return userId;
  }

  public void setUserid(Long userId) {
    this.userId = userId;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionid(Long questionId) {
    this.questionId = questionId;
  }

  public Long getTestcaseid() {
    return testcaseid;
  }

  public void setTestcaseid(Long testcaseid) {
    this.testcaseid = testcaseid;
  }  

  public OffsetDateTime getRunstarttimeutc() {
    return runstartTimeutc;
  }  

  public void setRunstarttimeutc(OffsetDateTime runstartTimeutc) {
    this.runstartTimeutc = runstartTimeutc;
  }  

  public OffsetDateTime getRunendtimeutc() {
    return runendTimeutc;
  }  

  public void setRunendtimeutc(OffsetDateTime runendTimeutc) {
    this.runendTimeutc = runendTimeutc;
  }    

  public LocalDateTime getRunstarttime() {
    return runstartTime;
  }  

  public void setRunstarttime(LocalDateTime runstartTime) {
    this.runstartTime = runstartTime;
  } 

  public LocalDateTime getRunendtime() {
    return runendTime;
  }  

  public void setRunendtime(LocalDateTime runendTime) {
    this.runendTime = runendTime;
  }   

  public String getTestcasefilepath() {
    return testcasefilepath;
  }  

  public void setTestcasefilepath(String testcasefilepath) {
    this.testcasefilepath = testcasefilepath;
  }   

  public String getFilename() {
    return fileName;
  }  

  public void setFilename(String fileName) {
    this.fileName = fileName;
  }     


  public String getTestcasepassstatus() {
    return testcasepassstatus;
  }

  public void setTestcasepassstatus(String testcasepassstatus) {
    this.testcasepassstatus = testcasepassstatus;
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
