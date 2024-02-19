package com.venturenix.cmc.payload.response;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String firstname;
  private String lastname;
  private String username;
  private String email;
  private String mobile;
  private String company;
  private String title;
  private Long py_experience;
  private Long jv_experience;
  private Long js_experience;
  private Long cs_experience;
  private Long sa_experience;
  private LocalDateTime createddate;
  private Long createdby;
  private LocalDateTime updateddate;
  private Long updatedby; 
  private String status;

  private List<String> roles;

  public JwtResponse(String accessToken, Long id, String firstname, String lastname, String mobile, String email, String username, String company, String title, Long py_experience, Long jv_experience, Long js_experience, Long cs_experience, Long sa_experience, String status, LocalDateTime createdate, Long createby, LocalDateTime updatedate, Long updateby, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;    
    this.mobile = mobile;
    this.email = email;
    this.username = username;
    this.company = company;
    this.title = title;
    this.py_experience = py_experience;
    this.jv_experience = jv_experience;
    this.js_experience = js_experience;
    this.cs_experience = cs_experience;
    this.sa_experience = sa_experience;
    this.status = status;
    this.createddate = createddate;
    this.createdby = createdby;
    this.updateddate = updateddate;
    this.updatedby = updatedby;
    this.roles = roles;
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

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getPy_experience() {
    return py_experience;
  }

  public void setPy_experience(Long py_experience) {
    this.py_experience = py_experience;
  }

  public Long getJv_experience() {
    return jv_experience;
  }

  public void setJv_experience(Long jv_experience) {
    this.jv_experience = jv_experience;
  }
  
  public Long getJs_experience() {
    return js_experience;
  }

  public void setJs_experience(Long js_experience) {
    this.js_experience = js_experience;
  }
  
  public Long getCs_experience() {
    return cs_experience;
  }

  public void setCs_experience(Long cs_experience) {
    this.cs_experience = cs_experience;
  }
  
  public Long getSa_experience() {
    return sa_experience;
  }

  public void setSa_experience(Long sa_experience) {
    this.sa_experience = sa_experience;
  }  

public Long getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Long createdby) {
    this.createdby = createdby;
  }

  public LocalDateTime getCreateddate() {
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


  public List<String> getRoles() {
    return roles;
  }
}
