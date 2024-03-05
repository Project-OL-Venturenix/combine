package com.venturenix.cmc.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.OffsetDateTime;
@Entity
@Table(name = "usertestcases")
public class UserTestCase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long eventid;
  private Long userid;
  private Long questionid;
  private Long testcaseid;
  private String testcasepassstatus;
  private OffsetDateTime runstarttimeutc;
  private OffsetDateTime  runendtimeutc;
  private OffsetDateTime  runtimeutc;
  private LocalDateTime  runstarttime;    
  private LocalDateTime runendtime;
  private String testcasefilepath;
  private String filename;    
  private String status;
  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby;

  public UserTestCase() {
    
  }

  public UserTestCase(Long eventid, Long userid, Long questionid, Long testcaseid, OffsetDateTime runstarttimeutc, OffsetDateTime runtimeutc, OffsetDateTime runendtimeutc, LocalDateTime runstarttime, LocalDateTime runendtime, String testcasefilepath, String filename, String testcasepassstatus, String status, LocalDateTime createddate, Integer createdby, LocalDateTime updateddate, Integer updatedby) {
    this.eventid = eventid;
    this.userid = userid;
    this.questionid = questionid;
    this.testcaseid = testcaseid;
    this.runstarttimeutc = runstarttimeutc;
    this.runendtimeutc = runendtimeutc;
    this.runtimeutc = runtimeutc;
    this.runstarttime = runstarttime;
    this.runendtime = runendtime;
    this.testcasefilepath = testcasefilepath;    
    this.filename = filename;
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

  public String getTestcasepassstatus() {
    return testcasepassstatus;
  }

  public void setTestcasepassstatus(String testcasepassstatus) {
    this.testcasepassstatus = testcasepassstatus;
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