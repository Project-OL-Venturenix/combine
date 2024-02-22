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
  private OffsetDateTime run_start_time_utc;
  //@NotBlank  
  private OffsetDateTime  run_end_time_utc;

  //@NotBlank  
  private OffsetDateTime  run_time_utc;

  //@NotBlank  
  private LocalDateTime  run_start_time;    
  //@NotBlank  
  private LocalDateTime run_end_time;
  //@NotBlank  
  private String testcasefilepath;
  //@NotBlank  
  private String filename;    
  //@NotBlank
  private String testcase_pass_status;      

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
    return run_start_time_utc;
  }  

  public void setRunstarttimeutc(OffsetDateTime run_start_time_utc) {
    this.run_start_time_utc = run_start_time_utc;
  }  

  public OffsetDateTime getRunendtimeutc() {
    return run_end_time_utc;
  }  

  public void setRunendtimeutc(OffsetDateTime run_end_time_utc) {
    this.run_end_time_utc = run_end_time_utc;
  }    

  
  public OffsetDateTime getRuntimeutc() {
    return run_time_utc;
  }  

  public void setRuntimeutc(OffsetDateTime run_time_utc) {
    this.run_time_utc = run_time_utc;
  } 

  public LocalDateTime getRunstarttime() {
    return run_start_time;
  }  

  public void setRunstarttime(LocalDateTime run_start_time) {
    this.run_start_time = run_start_time;
  } 

  public LocalDateTime getRunendtime() {
    return run_end_time;
  }  

  public void setRunendtime(LocalDateTime run_end_time) {
    this.run_end_time = run_end_time;
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
    return testcase_pass_status;
  }

  public void setTestcasepassstatus(String testcase_pass_status) {
    this.testcase_pass_status = testcase_pass_status;
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