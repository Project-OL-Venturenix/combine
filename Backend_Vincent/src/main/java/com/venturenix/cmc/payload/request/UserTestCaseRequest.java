package com.venturenix.cmc.payload.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.Size;

public class UserTestCaseRequest {

  //@NotBlank
  private Long eventid;
  //@NotBlank
  private Long userid;
  //@NotBlank
  private Long questionid;
  //@NotBlank
  private Long testcaseid;
  //@NotBlank
  private OffsetDateTime runstarttimeutc;
  //@NotBlank  
  private OffsetDateTime  runendtimeutc;

  //@NotBlank  
  private OffsetDateTime  runtimeutc;

  //@NotBlank  
  private LocalDateTime  runstarttime;    
  //@NotBlank  
  private LocalDateTime runendtime;
  //@NotBlank  
  private String testcasefilepath;
  //@NotBlank  
  private String filename;    
  //@NotBlank
  private String testcasepassstatus;      

  //@NotBlank
  private String status;

  
  private LocalDateTime createddate;

  
  private Integer createdby;

  
  private LocalDateTime updateddate;

  
  private Integer updatedby;

   public Long getEventid() {
    return eventid;
  }

  public void setEventid(Long eventid) {
    this.eventid = eventid;
  }

  public Long getUserid() {
    return userid;
  }

  public void setUserid(Long userid) {
    this.userid = userid;
  }

  public Long getQuestionid() {
    return questionid;
  }

  public void setQuestionid(Long questionid) {
    this.questionid = questionid;
  }

  public Long getTestcaseid() {
    return testcaseid;
  }

  public void setTestcaseid(Long testcaseid) {
    this.testcaseid = testcaseid;
  }  

  public OffsetDateTime getRunstarttimeutc() {
    return runstarttimeutc;
  }  

  public void setRunstarttimeutc(OffsetDateTime runstarttimeutc) {
    this.runstarttimeutc = runstarttimeutc;
  }  

  public OffsetDateTime getRunendtimeutc() {
    return runendtimeutc;
  }  

  public void setRunendtimeutc(OffsetDateTime runendtimeutc) {
    this.runendtimeutc = runendtimeutc;
  }    

  
  public OffsetDateTime getRuntimeutc() {
    return runtimeutc;
  }  

  public void setRuntimeutc(OffsetDateTime runtimeutc) {
    this.runtimeutc = runtimeutc;
  } 

  public LocalDateTime getRunstarttime() {
    return runstarttime;
  }  

  public void setRunstarttime(LocalDateTime runstarttime) {
    this.runstarttime = runstarttime;
  } 

  public LocalDateTime getRunendtime() {
    return runendtime;
  }  

  public void setRunendtime(LocalDateTime runendtime) {
    this.runendtime = runendtime;
  }   

  public String getTestcasefilepath() {
    return testcasefilepath;
  }  

  public void setTestcasefilepath(String testcasefilepath) {
    this.testcasefilepath = testcasefilepath;
  }   

  public String getFilename() {
    return filename;
  }  

  public void setFilename(String filename) {
    this.filename = filename;
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