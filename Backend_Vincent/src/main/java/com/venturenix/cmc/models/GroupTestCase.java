package com.venturenix.cmc.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.OffsetDateTime;
@Entity
@Table(name = "grouptestcases")
public class GroupTestCase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long eventid;
  private Long groupid;
  private Long userid;
  private Long questionid;
  private Long testcaseid;
  
  private OffsetDateTime run_start_time_utc;
  private OffsetDateTime  run_end_time_utc;
  private OffsetDateTime  run_time_utc;
  private LocalDateTime  run_start_time;    
  private LocalDateTime run_end_time;
  private String testcasefilepath;
  private String filename;    
  private String testcase_pass_status;
  private String status;
  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby;


  public GroupTestCase() {
    
  }

  public GroupTestCase(Long eventd, Long groupid, Long questionid, Long testcaseid, Long userid, OffsetDateTime run_start_time_utc, OffsetDateTime run_end_time_utc, OffsetDateTime run_time_utc, LocalDateTime run_start_time, LocalDateTime run_end_time, String testcasefilepath, String filename, String testcase_pass_status, String status, LocalDateTime createddate, Integer createdby, LocalDateTime updateddate, Integer updatedby) {
    this.eventid = eventid;
    this.groupid = groupid;
    this.questionid = questionid;
    this.testcaseid = testcaseid;
    this.userid = userid;
    this.run_start_time_utc = run_start_time_utc;
    this.run_end_time_utc = run_end_time_utc;
    this.run_time_utc = run_time_utc;
    this.run_start_time = run_start_time;
    this.run_end_time = run_end_time;
    this.testcasefilepath = testcasefilepath;    
    this.filename = filename;
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
    return testcase_pass_status;
  }

  public void setTestcasepassstatus(String testcase_pass_status) {
    this.testcase_pass_status = testcase_pass_status;
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