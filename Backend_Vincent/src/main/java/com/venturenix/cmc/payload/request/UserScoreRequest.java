package com.venturenix.cmc.payload.request;

import java.time.LocalDateTime;

public class UserScoreRequest {

  // @NotBlank
  private Long eventid;

  // @NotBlank
  private Long userid;

  // @NotBlank
  private Long questionid;

  // @NotBlank
  private Integer testcasePassTotal;

  // @NotBlank
  private Double testcaseScoreTotal;

  // @NotBlank
  private Integer testcasetotal = 10;



  private Integer createdby;



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

  public Integer getTestcasetotal() {
    return testcasetotal;
  }

  public Integer getTestcasepasstotal() {
    return testcasePassTotal;
  }

  public void setTestcasepasstotal(Integer testcasePassTotal) {
    this.testcasePassTotal = testcasePassTotal;
  }

  public Double getTestcasescoretotal() {
    return testcaseScoreTotal;
  }

  public void setTestcasescoretotal(Double testcaseScoreTotal) {
    this.testcaseScoreTotal = testcaseScoreTotal;
  }


  public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }


  public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }

}
