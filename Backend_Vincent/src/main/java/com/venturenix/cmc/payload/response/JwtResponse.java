package com.venturenix.cmc.payload.response;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Integer id;
  private String firstname;
  private String lastname;
  private String username;
  private String email;
  private String mobile;
  private String company;
  private String title;
  private Integer py_experience;
  private Integer jv_experience;
  private Integer js_experience;
  private Integer cs_experience;
  private Integer sa_experience;
  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby; 
  private String status;

  private List<String> roles;

  public JwtResponse(String accessToken, Integer id, String firstname, String lastname, String mobile, String email, String username, String company, String title, Integer py_experience, Integer jv_experience, Integer js_experience, Integer cs_experience, Integer sa_experience, String status, LocalDateTime createdate, Integer createby, LocalDateTime updatedate, Integer updateby, List<String> roles) {
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public Integer getPy_experience() {
    return py_experience;
  }

  public void setPy_experience(Integer py_experience) {
    this.py_experience = py_experience;
  }

  public Integer getJv_experience() {
    return jv_experience;
  }

  public void setJv_experience(Integer jv_experience) {
    this.jv_experience = jv_experience;
  }
  
  public Integer getJs_experience() {
    return js_experience;
  }

  public void setJs_experience(Integer js_experience) {
    this.js_experience = js_experience;
  }
  
  public Integer getCs_experience() {
    return cs_experience;
  }

  public void setCs_experience(Integer cs_experience) {
    this.cs_experience = cs_experience;
  }
  
  public Integer getSa_experience() {
    return sa_experience;
  }

  public void setSa_experience(Integer sa_experience) {
    this.sa_experience = sa_experience;
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


  public List<String> getRoles() {
    return roles;
  }
}
